package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class ExportPDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");

        if (accNum == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Session expired. Please login again.</h2>");
            out.close();
            return;
        }

        // Set response headers BEFORE creating the PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Transaction_History.pdf\"");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PDDocument document = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            // Create document
            document = new PDDocument();
            
            // Create fonts
            PDType1Font helvetica = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            PDType1Font helveticaBold = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);

            // Create first page
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Get database connection
            conn = DBConnection.getConnection();
            
            // Query database
            ps = conn.prepareStatement(
                "SELECT date, type, amount, balance, description FROM transactions WHERE account_number = ? ORDER BY date DESC"
            );
            ps.setString(1, accNum);
            rs = ps.executeQuery();

            // Create content stream
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            float leading = 18f;
            float margin = 50f;
            float yPosition = page.getMediaBox().getHeight() - margin;
            float xStart = margin;

            // Start text
            contentStream.beginText();
            contentStream.newLineAtOffset(xStart, yPosition);
            
            // Title
            contentStream.setFont(helveticaBold, 16);
            contentStream.showText("ROY BANK - TRANSACTION HISTORY");
            yPosition -= leading * 1.5f;
            contentStream.newLineAtOffset(0, -leading * 1.5f);
            
            // Account info
            contentStream.setFont(helvetica, 12);
            contentStream.showText("Account Number: " + accNum);
            yPosition -= leading;
            contentStream.newLineAtOffset(0, -leading);
            
            contentStream.showText("Generated on: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            yPosition -= leading * 2;
            contentStream.newLineAtOffset(0, -leading * 2);

            // Table Header
            contentStream.setFont(helveticaBold, 10);
            String header = String.format("%-12s %-10s %-15s %-15s %-25s", 
                "Date", "Type", "Amount", "Balance", "Description");
            contentStream.showText(header);
            yPosition -= leading;
            contentStream.newLineAtOffset(0, -leading);
            
            // Header underline
            contentStream.setFont(helvetica, 10);
            contentStream.showText("-------------------------------------------------------------------------------");
            yPosition -= leading;
            contentStream.newLineAtOffset(0, -leading);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            boolean hasData = false;
            
            while (rs.next()) {
                hasData = true;
                
                // Check if we need a new page
                if (yPosition < 100) {
                    contentStream.endText();
                    contentStream.close();
                    
                    // Create new page
                    page = new PDPage(PDRectangle.A4);
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    yPosition = page.getMediaBox().getHeight() - margin;
                    
                    contentStream.beginText();
                    contentStream.newLineAtOffset(xStart, yPosition);
                    contentStream.setFont(helvetica, 10);
                }
                
                java.sql.Date date = rs.getDate("date");
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                double balance = rs.getDouble("balance");
                String desc = rs.getString("description");

                // Handle null description
                if (desc == null) desc = "";
                if (desc.length() > 23) {
                    desc = desc.substring(0, 20) + "...";
                }

                String line = String.format("%-12s %-10s Rs.%-12.2f Rs.%-12.2f %-25s",
                    sdf.format(date), type, amount, balance, desc);

                contentStream.showText(line);
                yPosition -= leading;
                contentStream.newLineAtOffset(0, -leading);
            }

            if (!hasData) {
                contentStream.showText("No transactions found for this account.");
            }

            // End text and close content stream
            contentStream.endText();
            contentStream.close();
            
            // Save to ByteArrayOutputStream first
            document.save(baos);
            
            // Write to response
            response.setContentLength(baos.size());
            OutputStream out = response.getOutputStream();
            baos.writeTo(out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            
            // Clear any content that might have been written
            response.reset();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Error generating PDF: " + e.getMessage() + "</h2>");
            out.println("<p>Please check server logs for details.</p>");
            out.close();
            
        } finally {
            // Close all resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
                if (document != null) document.close();
                if (baos != null) baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}