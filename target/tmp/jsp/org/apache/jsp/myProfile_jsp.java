package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/template/header.jsp");
    _jspx_dependants.add("/template/footer.jsp");
  }

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


    if (session.getAttribute("id") == null || session.getAttribute("id").equals("")) response.sendRedirect("/login.jsp");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- Latest compiled and minified CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Latest compiled and minified Locales -->\r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/myProfile.css\" />\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-5  toppad  pull-right col-md-offset-3 \">\r\n");
      out.write("\r\n");
      out.write("                <a href=\"/logout\" >Logout</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"panel panel-info\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h3 class=\"panel-title\">");
      out.print( session.getAttribute("email") );
      out.write("</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <form>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-3 col-lg-3 \" align=\"center\"> <img alt=\"User Pic\" src=\"upload/");
      out.print( session.getAttribute("urlPhoto") );
      out.write("\" class=\"img-circle img-responsive photo\"> </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\" col-md-9 col-lg-9 \">\r\n");
      out.write("                                <table class=\"table table-user-information\">\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>ID:</td>\r\n");
      out.write("                                        <td>");
      out.print( session.getAttribute("id") );
      out.write("</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Email:</td>\r\n");
      out.write("                                        <td>");
      out.print( session.getAttribute("email") );
      out.write("</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Created Date:</td>\r\n");
      out.write("                                        <td>");
      out.print( session.getAttribute("createdDate") );
      out.write("</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                                <input type=\"file\" id=\"file\" name=\"file\" size=\"50\" />\r\n");
      out.write("                                <input type=\"button\" class=\"btn btn-primary pull-right upload\" value=\"Upload Image\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"panel-footer\">\r\n");
      out.write("                        <div class=\"message\" id=\"message\"></div>\r\n");
      out.write("                        <!--<a data-original-title=\"Broadcast Message\" data-toggle=\"tooltip\" type=\"button\" class=\"btn btn-sm btn-primary\"><i class=\"glyphicon glyphicon-envelope\"></i></a>\r\n");
      out.write("                        <span class=\"pull-right\">\r\n");
      out.write("                            <a href=\"edit.html\" data-original-title=\"Edit this user\" data-toggle=\"tooltip\" type=\"button\" class=\"btn btn-sm btn-warning\"><i class=\"glyphicon glyphicon-edit\"></i></a>\r\n");
      out.write("                            <a data-original-title=\"Remove this user\" data-toggle=\"tooltip\" type=\"button\" class=\"btn btn-sm btn-danger\"><i class=\"glyphicon glyphicon-remove\"></i></a>\r\n");
      out.write("                        </span>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div> <!-- /container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('.upload').on('click', function(){\r\n");
      out.write("            var files = $('#file')[0].files[0];\r\n");
      out.write("            var data_string = {\r\n");
      out.write("                files\t\t\t: files\r\n");
      out.write("            }\r\n");
      out.write("            var formData = new FormData();\r\n");
      out.write("            for (var key in data_string) {\r\n");
      out.write("                formData.append(key, data_string[key]);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: '/upload',\r\n");
      out.write("                type: 'POST',\r\n");
      out.write("                dataType: 'JSON',\r\n");
      out.write("                data: formData,\r\n");
      out.write("                enctype: 'multipart/form-data',\r\n");
      out.write("                processData: false,  // tell jQuery not to process the data\r\n");
      out.write("                contentType: false,\r\n");
      out.write("                success: function (r) {\r\n");
      out.write("                    $('#message').html('');\r\n");
      out.write("\r\n");
      out.write("                    if(r.uploadState){\r\n");
      out.write("                        $('.photo').prop('src', 'upload/'+r.msg);\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $('#message').html('<div class=\"alert alert-danger\">  <strong>' + r.msg + '</strong></a></div>');\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        })\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("<script src=\"../bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
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
