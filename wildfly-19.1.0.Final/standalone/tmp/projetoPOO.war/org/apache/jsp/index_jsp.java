/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 19.1.0.Final (WildFly Core 11.1.1.Final) - 2.1.0.Final
 * Generated at: 2023-06-14 20:23:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      response.addHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: rgba(210, 210, 210, 0.8);\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .login-container {\r\n");
      out.write("            width: 300px;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background-color: rgba(255, 255, 255, 0.9);\r\n");
      out.write("            border: 1px solid #dddddd;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"text\"],\r\n");
      out.write("        input[type=\"password\"] {\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("            border-radius: 3px;\r\n");
      out.write("            border: 1px solid #cccccc;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button[type=\"submit\"] {\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: #ffffff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 3px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button[type=\"submit\"]:hover {\r\n");
      out.write("            background-color: #45a049;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .register-link {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #333333;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            transition: color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .register-link:hover {\r\n");
      out.write("            color: #45a049;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"login-container\">\r\n");
      out.write("    <h2>LOGIN</h2>\r\n");
      out.write("    <div>\r\n");
      out.write("        <form method=\"POST\" action=\"usuariocontroller\">\r\n");
      out.write("            <label for=\"login\">Login:</label>\r\n");
      out.write("            <input type=\"text\" name=\"login\" id=\"login\" required> <br />\r\n");
      out.write("            <label for=\"senha\" >Senha:</label>\r\n");
      out.write("            <input type=\"password\" id=\"senha\" name=\"senha\" required>\r\n");
      out.write("            <input type=\"hidden\" name=\"acao\" value=\"fazerlogin\">\r\n");
      out.write("            <br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <button type=\"submit\">Entrar</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <a class=\"register-link\" href=\"registrar.jsp\">Cadastrar-se</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
