/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.42
 * Generated at: 2025-07-06 17:29:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class transfer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

    if (session.getAttribute("accountNumber") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\" />\r\n");
      out.write("  <title>Transfer | ROY BANK</title>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("  <style>\r\n");
      out.write("   * {\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            font-family: 'Poppins', sans-serif;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            background: linear-gradient(135deg, #ff9a56 0%, #ffad85 25%, #ffc3a0 50%, #ffad85 75%, #ff9a56 100%);\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            overflow-x: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Animated background elements */\r\n");
      out.write("        body::before {\r\n");
      out.write("            content: '';\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: -50%;\r\n");
      out.write("            left: -50%;\r\n");
      out.write("            width: 200%;\r\n");
      out.write("            height: 200%;\r\n");
      out.write("            background: radial-gradient(circle, rgba(255,255,255,0.1) 1px, transparent 1px);\r\n");
      out.write("            background-size: 50px 50px;\r\n");
      out.write("            animation: float 20s linear infinite;\r\n");
      out.write("            pointer-events: none;\r\n");
      out.write("            z-index: 1;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes float {\r\n");
      out.write("            0% { transform: translateY(0) rotate(0deg); }\r\n");
      out.write("            100% { transform: translateY(-100px) rotate(360deg); }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Floating money icons */\r\n");
      out.write("        .floating-money {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            pointer-events: none;\r\n");
      out.write("            z-index: 1;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .money-icon {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            color: rgba(255, 255, 255, 0.2);\r\n");
      out.write("            animation: floatMoney 8s linear infinite;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .money-icon:nth-child(1) { left: 10%; animation-delay: 0s; }\r\n");
      out.write("        .money-icon:nth-child(2) { left: 20%; animation-delay: 2s; }\r\n");
      out.write("        .money-icon:nth-child(3) { left: 30%; animation-delay: 4s; }\r\n");
      out.write("        .money-icon:nth-child(4) { left: 70%; animation-delay: 1s; }\r\n");
      out.write("        .money-icon:nth-child(5) { left: 80%; animation-delay: 3s; }\r\n");
      out.write("        .money-icon:nth-child(6) { left: 90%; animation-delay: 5s; }\r\n");
      out.write("\r\n");
      out.write("        @keyframes floatMoney {\r\n");
      out.write("            0% { transform: translateY(100vh) rotate(0deg); opacity: 0; }\r\n");
      out.write("            10% { opacity: 1; }\r\n");
      out.write("            90% { opacity: 1; }\r\n");
      out.write("            100% { transform: translateY(-100px) rotate(360deg); opacity: 0; }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        header {\r\n");
      out.write("            background: linear-gradient(135deg, #ff6600, #ff8533, #ffad85);\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 25px 20px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-size: 28px;\r\n");
      out.write("            font-weight: 700;\r\n");
      out.write("            letter-spacing: 2px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            box-shadow: 0 4px 20px rgba(255, 102, 0, 0.3);\r\n");
      out.write("            z-index: 10;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        header::before {\r\n");
      out.write("            content: '';\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: -50%;\r\n");
      out.write("            left: -50%;\r\n");
      out.write("            width: 200%;\r\n");
      out.write("            height: 200%;\r\n");
      out.write("            background: linear-gradient(45deg, transparent, rgba(255,255,255,0.1), transparent);\r\n");
      out.write("            animation: shine 4s linear infinite;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes shine {\r\n");
      out.write("            0% { transform: translateX(-100%) translateY(-100%); }\r\n");
      out.write("            100% { transform: translateX(100%) translateY(100%); }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .home-btn {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 20px;\r\n");
      out.write("            top: 50%;\r\n");
      out.write("            transform: translateY(-50%);\r\n");
      out.write("            background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("            color: #ff6600;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            padding: 12px 20px;\r\n");
      out.write("            border-radius: 50px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            border: 2px solid rgba(255, 255, 255, 0.3);\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("            backdrop-filter: blur(10px);\r\n");
      out.write("            box-shadow: 0 4px 15px rgba(255, 255, 255, 0.3);\r\n");
      out.write("            z-index: 2;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .home-btn:hover {\r\n");
      out.write("            background: white;\r\n");
      out.write("            color: #e65c00;\r\n");
      out.write("            transform: translateY(-50%) scale(1.05);\r\n");
      out.write("            box-shadow: 0 6px 20px rgba(255, 255, 255, 0.4);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        main {\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            padding: 40px 20px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            z-index: 10;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-container {\r\n");
      out.write("            background: rgba(255, 255, 255, 0.95);\r\n");
      out.write("            backdrop-filter: blur(20px);\r\n");
      out.write("            border: 1px solid rgba(255, 255, 255, 0.2);\r\n");
      out.write("            padding: 50px 60px;\r\n");
      out.write("            border-radius: 24px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            max-width: 500px;\r\n");
      out.write("            box-shadow: 0 25px 50px rgba(255, 102, 0, 0.2);\r\n");
      out.write("            position: relative;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            animation: slideUp 0.8s ease-out;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes slideUp {\r\n");
      out.write("            from {\r\n");
      out.write("                opacity: 0;\r\n");
      out.write("                transform: translateY(50px);\r\n");
      out.write("            }\r\n");
      out.write("            to {\r\n");
      out.write("                opacity: 1;\r\n");
      out.write("                transform: translateY(0);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-container::before {\r\n");
      out.write("            content: '';\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            right: 0;\r\n");
      out.write("            height: 4px;\r\n");
      out.write("            background: linear-gradient(90deg, #ff6600, #ff8533, #ffad85, #ff8533, #ff6600);\r\n");
      out.write("            background-size: 300% 100%;\r\n");
      out.write("            animation: gradientShift 3s ease infinite;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes gradientShift {\r\n");
      out.write("            0%, 100% { background-position: 0% 50%; }\r\n");
      out.write("            50% { background-position: 100% 50%; }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-header {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 40px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .deposit-icon {\r\n");
      out.write("            width: 80px;\r\n");
      out.write("            height: 80px;\r\n");
      out.write("            background: linear-gradient(135deg, #ff6600, #ff8533);\r\n");
      out.write("            border-radius: 50%;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            font-size: 36px;\r\n");
      out.write("            color: white;\r\n");
      out.write("            margin: 0 auto 20px;\r\n");
      out.write("            box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);\r\n");
      out.write("            animation: pulse 2s ease-in-out infinite;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @keyframes pulse {\r\n");
      out.write("            0%, 100% { transform: scale(1); }\r\n");
      out.write("            50% { transform: scale(1.05); }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            color: #333;\r\n");
      out.write("            font-size: 28px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-subtitle {\r\n");
      out.write("            color: #666;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            font-weight: 300;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .form-group {\r\n");
      out.write("            margin-bottom: 30px;\r\n");
      out.write("            position: relative;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 8px;\r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("            letter-spacing: 0.5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-wrapper {\r\n");
      out.write("            position: relative;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .currency-symbol {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 15px;\r\n");
      out.write("            top: 50%;\r\n");
      out.write("            transform: translateY(-50%);\r\n");
      out.write("            color: #ff6600;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("            z-index: 2;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"number\"] {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 16px 16px 16px 45px;\r\n");
      out.write("            border: 2px solid #e0e0e0;\r\n");
      out.write("            border-radius: 12px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\r\n");
      out.write("            backdrop-filter: blur(5px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"number\"]:focus {\r\n");
      out.write("            border-color: #ff6600;\r\n");
      out.write("            outline: none;\r\n");
      out.write("            box-shadow: 0 0 0 3px rgba(255, 102, 0, 0.1);\r\n");
      out.write("            transform: translateY(-2px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"number\"]:hover {\r\n");
      out.write("            border-color: #ff8533;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .submit-btn {\r\n");
      out.write("            background: linear-gradient(135deg, #ff6600, #ff8533);\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 18px 24px;\r\n");
      out.write("            border-radius: 50px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("            box-shadow: 0 8px 25px rgba(255, 102, 0, 0.3);\r\n");
      out.write("            position: relative;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .submit-btn::before {\r\n");
      out.write("            content: '';\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: -100%;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.3), transparent);\r\n");
      out.write("            transition: left 0.5s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .submit-btn:hover::before {\r\n");
      out.write("            left: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .submit-btn:hover {\r\n");
      out.write("            transform: translateY(-2px);\r\n");
      out.write("            box-shadow: 0 12px 35px rgba(255, 102, 0, 0.4);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .submit-btn:active {\r\n");
      out.write("            transform: translateY(0);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .amount-suggestions {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            gap: 10px;\r\n");
      out.write("            margin-top: 15px;\r\n");
      out.write("            flex-wrap: wrap;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .amount-btn {\r\n");
      out.write("            background: rgba(255, 102, 0, 0.1);\r\n");
      out.write("            color: #ff6600;\r\n");
      out.write("            border: 1px solid rgba(255, 102, 0, 0.3);\r\n");
      out.write("            padding: 8px 16px;\r\n");
      out.write("            border-radius: 20px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            min-width: 80px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .amount-btn:hover {\r\n");
      out.write("            background: rgba(255, 102, 0, 0.2);\r\n");
      out.write("            transform: translateY(-1px);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        footer {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            padding: 30px 20px;\r\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\r\n");
      out.write("            color: #666;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            backdrop-filter: blur(10px);\r\n");
      out.write("            position: relative;\r\n");
      out.write("            z-index: 10;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .footer-gradient {\r\n");
      out.write("            background: linear-gradient(135deg, #ff6600, #ff8533);\r\n");
      out.write("            -webkit-background-clip: text;\r\n");
      out.write("            -webkit-text-fill-color: transparent;\r\n");
      out.write("            background-clip: text;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Responsive design */\r\n");
      out.write("        @media (max-width: 768px) {\r\n");
      out.write("            .form-container {\r\n");
      out.write("                padding: 40px 30px;\r\n");
      out.write("                margin: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .home-btn {\r\n");
      out.write("                left: 15px;\r\n");
      out.write("                padding: 10px 16px;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            header {\r\n");
      out.write("                font-size: 24px;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            h2 {\r\n");
      out.write("                font-size: 24px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .deposit-icon {\r\n");
      out.write("                width: 70px;\r\n");
      out.write("                height: 70px;\r\n");
      out.write("                font-size: 32px;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @media (max-width: 480px) {\r\n");
      out.write("            .form-container {\r\n");
      out.write("                padding: 30px 20px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .amount-suggestions {\r\n");
      out.write("                flex-direction: column;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .amount-btn {\r\n");
      out.write("                flex: none;\r\n");
      out.write("                min-width: auto;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    .transfer-icon {\r\n");
      out.write("      width: 80px;\r\n");
      out.write("      height: 80px;\r\n");
      out.write("      background: linear-gradient(135deg, #ff6600, #ff8533);\r\n");
      out.write("      border-radius: 50%;\r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      justify-content: center;\r\n");
      out.write("      font-size: 36px;\r\n");
      out.write("      color: white;\r\n");
      out.write("      margin: 0 auto 20px;\r\n");
      out.write("      box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);\r\n");
      out.write("      animation: pulse 2s ease-in-out infinite;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- Floating icons -->\r\n");
      out.write("  <div class=\"floating-money\">\r\n");
      out.write("    <div class=\"money-icon\">🔁</div>\r\n");
      out.write("    <div class=\"money-icon\">💳</div>\r\n");
      out.write("    <div class=\"money-icon\">💵</div>\r\n");
      out.write("    <div class=\"money-icon\">🏦</div>\r\n");
      out.write("    <div class=\"money-icon\">💸</div>\r\n");
      out.write("    <div class=\"money-icon\">💰</div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <header>\r\n");
      out.write("    <a href=\"dashboard.jsp\" class=\"home-btn\">🏠 Home</a>\r\n");
      out.write("    ROY BANK\r\n");
      out.write("  </header>\r\n");
      out.write("\r\n");
      out.write("  <main>\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("      <div class=\"form-header\">\r\n");
      out.write("        <div class=\"transfer-icon\">🔁</div>\r\n");
      out.write("        <h2>Transfer Funds</h2>\r\n");
      out.write("        <p class=\"form-subtitle\">Send money to another account safely</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <form action=\"TransferServlet\" method=\"post\">\r\n");
      out.write("        <input type=\"hidden\" name=\"sender\" value=\"");
      out.print( session.getAttribute("accountNumber") );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("          <label for=\"receiver\">Recipient Account Number</label>\r\n");
      out.write("          <div class=\"input-wrapper\">\r\n");
      out.write("            <input type=\"text\" name=\"receiver\" id=\"receiver\" required placeholder=\"e.g. AC1002\">\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("          <label for=\"amount\">Amount to Transfer</label>\r\n");
      out.write("          <div class=\"input-wrapper\">\r\n");
      out.write("            <span class=\"currency-symbol\">₹</span>\r\n");
      out.write("            <input type=\"number\" name=\"amount\" id=\"amount\" min=\"1\" required placeholder=\"Enter amount\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"amount-suggestions\">\r\n");
      out.write("            <button type=\"button\" class=\"amount-btn\" onclick=\"setAmount(500)\">₹500</button>\r\n");
      out.write("            <button type=\"button\" class=\"amount-btn\" onclick=\"setAmount(1000)\">₹1,000</button>\r\n");
      out.write("            <button type=\"button\" class=\"amount-btn\" onclick=\"setAmount(2000)\">₹2,000</button>\r\n");
      out.write("            <button type=\"button\" class=\"amount-btn\" onclick=\"setAmount(5000)\">₹5,000</button>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"submit\" value=\"🔁 Transfer Now\" class=\"submit-btn\">\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </main>\r\n");
      out.write("\r\n");
      out.write("  <footer>\r\n");
      out.write("    <p>&copy; 2025 <span class=\"footer-gradient\">ROY BANK</span>. All rights reserved.</p>\r\n");
      out.write("    <p>Secure • Fast • Reliable</p>\r\n");
      out.write("  </footer>\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("    function setAmount(amount) {\r\n");
      out.write("      document.getElementById('amount').value = amount;\r\n");
      out.write("    }\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
