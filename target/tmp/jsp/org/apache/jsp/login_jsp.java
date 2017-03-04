package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <form class=\"form-signin\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"message\" id=\"message\"></div>\r\n");
      out.write("\r\n");
      out.write("        <h4 class=\"form-signin-heading\">Please sign in</h4>\r\n");
      out.write("        <hr/>\r\n");
      out.write("        <label for=\"email\" class=\"sr-only\">Username</label>\r\n");
      out.write("        <input type=\"text\" id=\"email\" class=\"form-control email\" name=\"email\" placeholder=\"Email\" autofocus value=\"admin@gmail.com\">\r\n");
      out.write("        <label for=\"password\" class=\"sr-only\">Password</label>\r\n");
      out.write("        <input type=\"password\" id=\"password\" class=\"form-control password\" name=\"password\" placeholder=\"Password\" value=\"admin@gmail.com\">\r\n");
      out.write("\r\n");
      out.write("        <button class=\"btn btn-primary btn-block\" type=\"button\" id=\"sign-in\">Sign in</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div> <!-- /container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('#sign-in').on('click', function(){\r\n");
      out.write("            var email = $('#email').val();\r\n");
      out.write("            var password = $('#password').val();\r\n");
      out.write("\r\n");
      out.write("            $(\"#message\").html(\"\");\r\n");
      out.write("\r\n");
      out.write("            $.post(\"/login\", {email : email, password : password}, function(r){\r\n");
      out.write("                if(r.isLogin) {\r\n");
      out.write("                    //$('#message').html('<div class=\"alert alert-success\"> <strong>Login Success!</strong></a></div>');\r\n");
      out.write("                    window.location = '/customerLists.jsp';\r\n");
      out.write("                }\r\n");
      out.write("                else  $('#message').html('<div class=\"alert alert-danger\">  <strong>Login Fail!</strong></a></div>');\r\n");
      out.write("            }, \"JSON\");\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("<script src=\"../bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
