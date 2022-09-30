package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.ManagementDTO;
import dao.ManagementDAO;

public final class adminAddFaculty_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Add Faculty</title>\n");
      out.write("    <link rel=\"shortcut icon\" href=\"img/title.png\" type=\"image/x-icon\">\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("    <link href=\"css/nstyle.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style4.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css\">\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\" charset=\"utf-8\"></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");

    String username=(String)session.getAttribute("username");
    String category=(String)session.getAttribute("category");
    if(username ==null || !(category.equals("admin")))
    {
        response.sendRedirect("login.jsp");
    }

      out.write('\n');

     String b = (String)request.getAttribute("message");
      if(b!=null)
      {

      out.write("\n");
      out.write("      \n");
      out.write("<script>        \n");
      out.write("{\n");
      out.write("  alert(b);\n");
      out.write("}\n");
      out.write("</script>\n");

 }       

      out.write("\n");
      out.write("    <input type=\"checkbox\" id=\"check\">\n");
      out.write("    <!--header area start-->\n");
      out.write("    <header>\n");
      out.write("      <label for=\"check\">\n");
      out.write("        <i class=\"fas fa-bars\" id=\"sidebar_btn\"></i>\n");
      out.write("      </label>\n");
      out.write("      <div class=\"left_area\">\n");
      out.write("        <h3>ADMIN <span>PAGE</span></h3>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"right_area\">\n");
      out.write("        <a href=\"LogOutCheckerServlet\" class=\"logout_btn\">Logout</a>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("    <!--header area end-->\n");
      out.write("    <!--mobile navigation bar start-->\n");
      out.write("    <div class=\"mobile_nav\">\n");
      out.write("      <div class=\"nav_bar\">\n");
      out.write("        <img src=\"1.png\" class=\"mobile_profile_image\" alt=\"\">\n");
      out.write("        <i class=\"fa fa-bars nav_btn\"></i>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"mobile_nav_items\">\n");
      out.write("        <a href=\"adminHome.jsp\"><i class=\"fas fa-desktop\"></i><span>Profile</span></a>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Add New &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminAddHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD</span></a>\n");
      out.write("            <a href=\"adminAddFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty</span></a>\n");
      out.write("            <a href=\"adminAddStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Update &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminUpdateProfile.jsp\"><i class=\"fas fa-th\"></i><span>Profile</span></a>\n");
      out.write("            <a href=\"getAddHodId.jsp\"><i class=\"fas fa-table\"></i><span>HOD Details</span></a>\n");
      out.write("            <a href=\"getAddFacultyId.jsp\"><i class=\"fas fa-th\"></i><span>Faculty Details</span></a>\n");
      out.write("            <a href=\"getAddStudentId.jsp\"><i class=\"fas fa-th\"></i><span>Student Details</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Delete &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminDeleteHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD Details</span></a>\n");
      out.write("            <a href=\"adminDeleteFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty Details</span></a>\n");
      out.write("            <a href=\"adminDeleteStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student Details</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Display All &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminDisplayHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD</span></a>\n");
      out.write("            <a href=\"adminDisplayFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty</span></a>\n");
      out.write("            <a href=\"adminDisplayStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <a href=\"LogOutCheckerServlet\"><i class=\"fas fa-sliders-h\"></i><span>Log Out</span></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!--mobile navigation bar end-->\n");
      out.write("    <!--sidebar start-->\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("      <div class=\"profile_info\">\n");
      out.write("        <img src=\"1.png\" class=\"profile_image\" alt=\"\">\n");
      out.write("      </div>\n");
      out.write("      <a href=\"adminHome.jsp\"><i class=\"fas fa-desktop\"></i><span>Profile</span></a>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Add New &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminAddHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD</span></a>\n");
      out.write("            <a href=\"adminAddFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty</span></a>\n");
      out.write("            <a href=\"adminAddStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Update &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminUpdateProfile.jsp\"><i class=\"fas fa-th\"></i><span>Profile</span></a>\n");
      out.write("            <a href=\"getAddHodId.jsp\"><i class=\"fas fa-table\"></i><span>HOD Details</span></a>\n");
      out.write("            <a href=\"getAddFacultyId.jsp\"><i class=\"fas fa-th\"></i><span>Faculty Details</span></a>\n");
      out.write("            <a href=\"getAddStudentId.jsp\"><i class=\"fas fa-th\"></i><span>Student Details</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Delete &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminDeleteHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD Details</span></a>\n");
      out.write("            <a href=\"adminDeleteFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty Details</span></a>\n");
      out.write("            <a href=\"adminDeleteStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student Details</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"show1\">\n");
      out.write("        <a href=\"#\"><i class=\"fas fa-cogs\" ></i><span>Display All &nbsp; &nbsp;<i class=\"fas fa-chevron-down\"></i></span></a>\n");
      out.write("          <div class=\"hide1\">\n");
      out.write("            <a href=\"adminDisplayHod.jsp\"><i class=\"fas fa-table\"></i><span>HOD</span></a>\n");
      out.write("            <a href=\"adminDisplayFaculty.jsp\"><i class=\"fas fa-th\"></i><span>Faculty</span></a>\n");
      out.write("            <a href=\"adminDisplayStudent.jsp\"><i class=\"fas fa-th\"></i><span>Student</span></a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <a href=\"LogOutCheckerServlet\"><i class=\"fas fa-sliders-h\"></i><span>Log Out</span></a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--sidebar end-->\n");
      out.write("\n");
      out.write("    <div class=\"content\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"main-body\">\n");
      out.write("        \n");
      out.write("              <!-- Breadcrumb -->\n");
      out.write("              <nav aria-label=\"breadcrumb\" class=\"main-breadcrumb\">\n");
      out.write("                <ol class=\"breadcrumb\">\n");
      out.write("                   <li class=\"breadcrumb-item\"><a href=\"#\">HOME</a></li>\n");
      out.write("              <li class=\"breadcrumb-item\"><a href=\"javascript:void(0)\">ADMIN</a></li>\n");
      out.write("              <li class=\"breadcrumb-item active\" aria-current=\"page\">ADD Faculty</li>\n");
      out.write("            </ol>\n");
      out.write("              </nav>\n");
      out.write("              <!-- /Breadcrumb -->\n");
      out.write("<form action=\"AdminAddFacultyServlet\" method=\"post\">  \n");
      out.write("              <div class=\"container\">\n");
      out.write("                <div class=\"row gutters\">\n");
      out.write("                <div class=\"col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12\">\n");
      out.write("                <div class=\"addcard h-100\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"account-settings\">\n");
      out.write("                      <div class=\"user-profile\">\n");
      out.write("                        <div class=\"user-avatar\">\n");
      out.write("                          <img src=\"1.png\" alt=\"Maxwell Admin\">\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"about\">\n");
      out.write("                          <a href=\"#\" style=\"text-decoration: none;\"><button type=\"button\" class=\"btn btn-primary\">Upload Profile</button></a>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                </div>                    \n");
      out.write("                <div class=\"col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12\">\n");
      out.write("                <div class=\"addcard h-100\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"row gutters\">\n");
      out.write("                      <div class=\"col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12\">\n");
      out.write("                        <h6 class=\"mb-2 text-primary\">Basic Details</h6>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"fullName\">Full Name</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" name=\"name\" id=\"fullName\" placeholder=\"Enter full name\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                        <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"form-group\">Gender</label><br>\n");
      out.write("                          <input type=\"radio\"  name=\"gender\" value=\"male\" id=\"gender\" required>\n");
      out.write("                          <label for=\"gender\" style=\"color:grey;\">Male</label>&nbsp;&nbsp;\n");
      out.write("                          <input type=\"radio\"  name=\"gender\" value=\"female\" id=\"gender\" required>\n");
      out.write("                          <label for=\"gender\" style=\"color:grey;\">Female</label>&nbsp;&nbsp;\n");
      out.write("                          <input type=\"radio\"  name=\"gender\" value=\"other\" id=\"gender\" required>\n");
      out.write("                          <label for=\"gender\" style=\"color:grey;\">Other</label>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                        <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"password\">Password</label>\n");
      out.write("                          <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\" placeholder=\"Enter password\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                        <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"department\">Department</label>\n");
      out.write("                          <select id=\"department\" name=\"department\" class=\"form-control\" required>\n");
      out.write("                            <option value=\"\">--Select--</option>\n");
      out.write("                            <option value=\"Computer_Science\">Computer Science</option>\n");
      out.write("                            <option value=\"Information_Technology\">Information Technology</option>\n");
      out.write("                            <option value=\"Mechanical_Engineering\">Mechanical Engineering</option>\n");
      out.write("                            <option value=\"Chemical_Engineering\">Chemical Engineering</option>\n");
      out.write("                            <option value=\"Civil_Engineering\">Civil Engineering</option>\n");
      out.write("                            <option value=\"Electronics_and_communication_Engineering\">Electronics and communication Engineering</option>\n");
      out.write("                          </select>\n");
      out.write("                         </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"eMail\">Email</label>\n");
      out.write("                          <input type=\"email\" class=\"form-control\" name=\"email\" id=\"eMail\" placeholder=\"Enter email ID\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"designation\">Designation</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" name=\"designation\" id=\"designation\" placeholder=\"Enter designation\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("              </div><br>\n");
      out.write("              <div class=\"container\">\n");
      out.write("                <div class=\"row gutters\">\n");
      out.write("                <div class=\"col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12\">\n");
      out.write("                <div class=\"addcard h-100\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"row gutters\">\n");
      out.write("                      <div class=\"col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12\">\n");
      out.write("                        <h6 class=\"mb-2 text-primary\">Additional Details</h6>\n");
      out.write("                      </div>\n");
      out.write("                     <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"phone\">Contact</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" name=\"contact\" id=\"phone\" placeholder=\"Enter phone number\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"year\">Joining Year</label>\n");
      out.write("                          <input type=\"number\" class=\"form-control\" name=\"year\" id=\"year\" placeholder=\"YYYY\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"qualification\">Qualification</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" id=\"qualification\" name=\"qualification\" placeholder=\"Enter your qualification\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"experience\">Experience</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" id=\"experience\" name=\"experience\" placeholder=\"Enter experience\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"aadhar\">Aadhar No.</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" name=\"aadhar\" id=\"aadhar\" placeholder=\"Enter aadhar number\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                        <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"address\">Address</label>\n");
      out.write("                          <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" placeholder=\"Enter address\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                        <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"blood\">Blood Group</label>\n");
      out.write("                          <select id=\"blood\" name=\"blood\" class=\"form-control\" required>\n");
      out.write("                            <option value=\"\">--Select--</option>\n");
      out.write("                            <option value=\"A+\">A+</option>\n");
      out.write("                            <option value=\"B+\">B+</option>\n");
      out.write("                            <option value=\"AB+\">AB+</option>\n");
      out.write("                            <option value=\"O+\">O+</option>\n");
      out.write("                            <option value=\"O-\">O-</option>\n");
      out.write("                            <option value=\"A+\">A-</option>\n");
      out.write("                            <option value=\"B+\">B-</option>\n");
      out.write("                            <option value=\"AB+\">AB-</option>\n");
      out.write("                          </select>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                          <label for=\"dob\">DOB</label>\n");
      out.write("                          <input type=\"date\" class=\"form-control\" name=\"dob\" id=\"dob\" placeholder=\"Enter DOB\" required>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("                <br><center>\n");
      out.write("                  <button type=\"submit\" id=\"submit\" name=\"submit\" class=\"btn btn-primary\">ADD</button>\n");
      out.write("                  <a href=\"#\" style=\"text-decoration: none;\"><button type=\"reset\" id=\"submit\" name=\"submit\" class=\"btn btn-secondary\">Cancel</button></a>\n");
      out.write("              </center>   \n");
      out.write("</form>                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function(){\n");
      out.write("      $('.nav_btn').click(function(){\n");
      out.write("        $('.mobile_nav_items').toggleClass('active');\n");
      out.write("      });\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>");
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
