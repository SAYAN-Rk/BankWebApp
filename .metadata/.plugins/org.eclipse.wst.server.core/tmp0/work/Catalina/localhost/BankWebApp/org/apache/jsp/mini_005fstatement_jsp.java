/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.42
 * Generated at: 2025-07-06 15:32:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import com.bankapp.Transaction;
import java.text.SimpleDateFormat;

public final class mini_005fstatement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("com.bankapp.Transaction");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>Mini Statement | ROY BANK</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("    font-family: 'Poppins', sans-serif;\r\n");
      out.write("    background: linear-gradient(135deg, #ff9a56 0%, #ff6b35 50%, #f7931e 100%);\r\n");
      out.write("    min-height: 100vh;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    overflow-x: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Background Animation */\r\n");
      out.write("body::before {\r\n");
      out.write("    content: '';\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    top: 0;\r\n");
      out.write("    left: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    background: \r\n");
      out.write("        radial-gradient(circle at 20% 80%, rgba(255, 154, 86, 0.3) 0%, transparent 50%),\r\n");
      out.write("        radial-gradient(circle at 80% 20%, rgba(255, 107, 53, 0.3) 0%, transparent 50%),\r\n");
      out.write("        radial-gradient(circle at 40% 40%, rgba(247, 147, 30, 0.2) 0%, transparent 50%);\r\n");
      out.write("    z-index: -1;\r\n");
      out.write("    animation: backgroundFloat 20s ease-in-out infinite;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes backgroundFloat {\r\n");
      out.write("    0%, 100% { transform: translateY(0px) rotate(0deg); }\r\n");
      out.write("    50% { transform: translateY(-20px) rotate(1deg); }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Header Styles */\r\n");
      out.write("header {\r\n");
      out.write("    background: linear-gradient(135deg, #ff6b35, #f7931e);\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 2rem;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    position: relative;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("header::before {\r\n");
      out.write("    content: '';\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    top: -50%;\r\n");
      out.write("    left: -50%;\r\n");
      out.write("    width: 200%;\r\n");
      out.write("    height: 200%;\r\n");
      out.write("    background: repeating-linear-gradient(\r\n");
      out.write("        45deg,\r\n");
      out.write("        transparent,\r\n");
      out.write("        transparent 10px,\r\n");
      out.write("        rgba(255, 255, 255, 0.05) 10px,\r\n");
      out.write("        rgba(255, 255, 255, 0.05) 20px\r\n");
      out.write("    );\r\n");
      out.write("    animation: headerPattern 10s linear infinite;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes headerPattern {\r\n");
      out.write("    0% { transform: translateX(-50px) translateY(-50px); }\r\n");
      out.write("    100% { transform: translateX(50px) translateY(50px); }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header-content {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    z-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header-title {\r\n");
      out.write("    font-size: 2.5rem;\r\n");
      out.write("    font-weight: 700;\r\n");
      out.write("    margin-bottom: 0.5rem;\r\n");
      out.write("    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    letter-spacing: 1px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header-subtitle {\r\n");
      out.write("    font-size: 1.1rem;\r\n");
      out.write("    font-weight: 300;\r\n");
      out.write("    opacity: 0.9;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Main Container */\r\n");
      out.write(".container {\r\n");
      out.write("    max-width: 1200px;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    padding: 2rem;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    z-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Top Actions Bar */\r\n");
      out.write(".actions-bar {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    margin-bottom: 2rem;\r\n");
      out.write("    background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("    padding: 1.5rem;\r\n");
      out.write("    border-radius: 20px;\r\n");
      out.write("    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    border: 1px solid rgba(255, 255, 255, 0.2);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".page-title {\r\n");
      out.write("    font-size: 1.8rem;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    color: #ff6b35;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    gap: 0.5rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".export-btn {\r\n");
      out.write("    background: linear-gradient(135deg, #ff6b35, #f7931e);\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 1rem 2rem;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    border-radius: 50px;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    gap: 0.5rem;\r\n");
      out.write("    transition: all 0.3s ease;\r\n");
      out.write("    box-shadow: 0 5px 15px rgba(255, 107, 53, 0.3);\r\n");
      out.write("    border: none;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    font-size: 1rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".export-btn:hover {\r\n");
      out.write("    transform: translateY(-2px);\r\n");
      out.write("    box-shadow: 0 8px 25px rgba(255, 107, 53, 0.4);\r\n");
      out.write("    background: linear-gradient(135deg, #f7931e, #ff6b35);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".export-btn:active {\r\n");
      out.write("    transform: translateY(0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Table Container */\r\n");
      out.write(".table-container {\r\n");
      out.write("    background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("    border-radius: 20px;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("    box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    border: 1px solid rgba(255, 255, 255, 0.2);\r\n");
      out.write("    margin-bottom: 2rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Table Styles */\r\n");
      out.write("table {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    background: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("thead {\r\n");
      out.write("    background: linear-gradient(135deg, #ff6b35, #f7931e);\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("    padding: 1.5rem 1rem;\r\n");
      out.write("    font-size: 1rem;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th:not(:last-child)::after {\r\n");
      out.write("    content: '';\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    right: 0;\r\n");
      out.write("    top: 25%;\r\n");
      out.write("    height: 50%;\r\n");
      out.write("    width: 1px;\r\n");
      out.write("    background: rgba(255, 255, 255, 0.2);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tbody tr {\r\n");
      out.write("    transition: all 0.3s ease;\r\n");
      out.write("    border-bottom: 1px solid rgba(255, 107, 53, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tbody tr:hover {\r\n");
      out.write("    background: rgba(255, 107, 53, 0.05);\r\n");
      out.write("    transform: scale(1.01);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tbody tr:last-child {\r\n");
      out.write("    border-bottom: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("    padding: 1.2rem 1rem;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-size: 0.95rem;\r\n");
      out.write("    color: #333;\r\n");
      out.write("    font-weight: 500;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".amount {\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    color: #ff6b35;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".balance {\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    color: #2d5a87;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".transaction-type {\r\n");
      out.write("    padding: 0.3rem 0.8rem;\r\n");
      out.write("    border-radius: 20px;\r\n");
      out.write("    font-size: 0.8rem;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("    text-transform: uppercase;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".type-credit {\r\n");
      out.write("    background: linear-gradient(135deg, #4CAF50, #45a049);\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".type-debit {\r\n");
      out.write("    background: linear-gradient(135deg, #f44336, #d32f2f);\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* No Data State */\r\n");
      out.write(".no-data {\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 4rem 2rem;\r\n");
      out.write("    background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("    border-radius: 20px;\r\n");
      out.write("    box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    border: 1px solid rgba(255, 255, 255, 0.2);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".no-data-icon {\r\n");
      out.write("    font-size: 4rem;\r\n");
      out.write("    color: #ff6b35;\r\n");
      out.write("    margin-bottom: 1rem;\r\n");
      out.write("    opacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".no-data-text {\r\n");
      out.write("    font-size: 1.2rem;\r\n");
      out.write("    color: #666;\r\n");
      out.write("    font-weight: 500;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Footer */\r\n");
      out.write("footer {\r\n");
      out.write("    background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("    color: #666;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 2rem;\r\n");
      out.write("    font-size: 0.9rem;\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    border-top: 1px solid rgba(255, 107, 53, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive Design */\r\n");
      out.write("@media (max-width: 768px) {\r\n");
      out.write("    .header-title {\r\n");
      out.write("        font-size: 2rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .actions-bar {\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("        gap: 1rem;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .page-title {\r\n");
      out.write("        font-size: 1.5rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .export-btn {\r\n");
      out.write("        padding: 0.8rem 1.5rem;\r\n");
      out.write("        font-size: 0.9rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .container {\r\n");
      out.write("        padding: 1rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    table {\r\n");
      out.write("        font-size: 0.85rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    th, td {\r\n");
      out.write("        padding: 0.8rem 0.5rem;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (max-width: 480px) {\r\n");
      out.write("    .header-title {\r\n");
      out.write("        font-size: 1.5rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .actions-bar {\r\n");
      out.write("        padding: 1rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .page-title {\r\n");
      out.write("        font-size: 1.2rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    th, td {\r\n");
      out.write("        padding: 0.6rem 0.3rem;\r\n");
      out.write("        font-size: 0.8rem;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Animation Classes */\r\n");
      out.write(".fade-in {\r\n");
      out.write("    animation: fadeIn 0.6s ease-out;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes fadeIn {\r\n");
      out.write("    from { opacity: 0; transform: translateY(20px); }\r\n");
      out.write("    to { opacity: 1; transform: translateY(0); }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slide-up {\r\n");
      out.write("    animation: slideUp 0.5s ease-out;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes slideUp {\r\n");
      out.write("    from { opacity: 0; transform: translateY(30px); }\r\n");
      out.write("    to { opacity: 1; transform: translateY(0); }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"header-content\">\r\n");
      out.write("        <h1 class=\"header-title\">\r\n");
      out.write("            <i class=\"fas fa-university\"></i>\r\n");
      out.write("            ROY BANK\r\n");
      out.write("        </h1>\r\n");
      out.write("        <p class=\"header-subtitle\">Your Trusted Banking Partner</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"actions-bar fade-in\">\r\n");
      out.write("        <h2 class=\"page-title\">\r\n");
      out.write("            <i class=\"fas fa-file-invoice-dollar\"></i>\r\n");
      out.write("            Mini Statement\r\n");
      out.write("        </h2>\r\n");
      out.write("        <a href=\"ExportPDFServlet\" class=\"export-btn\">\r\n");
      out.write("            <i class=\"fas fa-file-pdf\"></i>\r\n");
      out.write("            Export to PDF\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");

    if (transactions != null && !transactions.isEmpty()) {
    
      out.write("\r\n");
      out.write("    <div class=\"table-container slide-up\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th><i class=\"fas fa-calendar-alt\"></i> Date</th>\r\n");
      out.write("                    <th><i class=\"fas fa-exchange-alt\"></i> Type</th>\r\n");
      out.write("                    <th><i class=\"fas fa-money-bill-wave\"></i> Amount</th>\r\n");
      out.write("                    <th><i class=\"fas fa-wallet\"></i> Balance</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                ");

                for (Transaction txn : transactions) {
                    String typeClass = txn.getType().toLowerCase().equals("credit") ? "type-credit" : "type-debit";
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( sdf.format(txn.getDate()) );
      out.write("</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <span class=\"transaction-type ");
      out.print( typeClass );
      out.write("\">\r\n");
      out.write("                            ");
      out.print( txn.getType() );
      out.write("\r\n");
      out.write("                        </span>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"amount\">Rs.");
      out.print( String.format("%.2f", txn.getAmount()) );
      out.write("</td>\r\n");
      out.write("                    <td class=\"balance\">Rs.");
      out.print( String.format("%.2f", txn.getBalance()) );
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                }
                
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

    } else {
    
      out.write("\r\n");
      out.write("    <div class=\"no-data fade-in\">\r\n");
      out.write("        <div class=\"no-data-icon\">\r\n");
      out.write("            <i class=\"fas fa-inbox\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"no-data-text\">\r\n");
      out.write("            No transactions found for your account.\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

    }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>&copy; 2025 ROY BANK. All rights reserved. | Secure Banking Solutions</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
