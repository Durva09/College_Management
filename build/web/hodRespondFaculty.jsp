<%@page import="dto.MessageDTO"%>
<%@page import="dao.MessageDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dto.StudentDTO"%>
<%@page import="dao.StudentDAO"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Complains</title>
    <link rel="shortcut icon" href="img/title.png" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="css/nstyle.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>

     <!-- Styles -->
     <link href="table/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
     <link href="table/css/jquery.datatables.min.css" rel="stylesheet" type="text/css"/>	
     
     <!-- Theme Styles -->
     <link href="table/css/modern.min.css" rel="stylesheet" type="text/css"/>
     
  </head>
  <body>
<%
    String username=(String)session.getAttribute("username");
    String category=(String)session.getAttribute("category");
    if(username ==null || !(category.equals("hod")))
    {
        response.sendRedirect("login.jsp");
    }
%>
    <input type="checkbox" id="check">
    <!--header area start-->
    <header>
      <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
      </label>
      <div class="left_area">
        <h3> HOD <span>PAGE</span></h3>
      </div>
      <div class="right_area">
        <a href="LogOutCheckerServlet" class="logout_btn">Logout</a>
      </div>
    </header>
    <!--header area end-->
    <!--mobile navigation bar start-->
    <div class="mobile_nav">
      <div class="nav_bar">
        <img src="1.png" class="mobile_profile_image" alt="">
        <i class="fa fa-bars nav_btn"></i>
      </div>
      <div class="mobile_nav_items">
       <a href="hodHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="hodUpdateProfile.jsp"><i class="fas fa-cogs" ></i><span>Update Profile&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Record &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="getHodFacultyId.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="getHodStudentId.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Display All &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodDisplayFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodDisplayStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Send Notice &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodSendNoticeFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodSendNoticeStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Send Assignment <i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodSendAssignmentFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodSendAssignmentStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Respond to Complain &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodRespondFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodRespondStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <a href="LogOutCheckerServlet"><i class="fas fa-sliders-h"></i><span>Log Out</span></a>
      </div>
    </div>
    <!--mobile navigation bar end-->
    <!--sidebar start-->
    <div class="sidebar">
      <div class="profile_info">
        <img src="1.png" class="profile_image" alt="">
    
      </div>
       <a href="hodHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="hodUpdateProfile.jsp"><i class="fas fa-cogs" ></i><span>Update Profile&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Send&nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodSendNoticeFaculty.jsp"><i class="fas fa-th"></i><span>Faculty Notice</span></a>
            <a href="hodSendNoticeStudent.jsp"><i class="fas fa-th"></i><span>Student Notice</span></a>
            <a href="hodSendAssignmentFaculty.jsp"><i class="fas fa-th"></i><span>Faculty Assignment</span></a>
            <a href="hodSendAssignmentStudent.jsp"><i class="fas fa-th"></i><span>Student Assignment</span></a>
          </div>
       </div>
     
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Record &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="getHodFacultyId.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="getHodStudentId.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Display All &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodDisplayFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodDisplayStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Respond a Complain <i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="hodRespondFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="hodRespondStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <a href="LogOutCheckerServlet"><i class="fas fa-sliders-h"></i><span>Log Out</span></a>
    </div>
    <!--sidebar end-->

    <div class="content">
      <div class="container">
        <div class="main-body">
        
              <!-- Breadcrumb -->
              <nav aria-label="breadcrumb" class="main-breadcrumb">
                <ol class="breadcrumb">
                   <li class="breadcrumb-item"><a href="#">HOME</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0)">HOD</a></li>
              <li class="breadcrumb-item active" aria-current="page">COMPLAIN LIST</li>
            </ol>
              </nav>
              <!-- /Breadcrumb -->
      
              <main class="page-content content-wrap">
           
            
                <div class="page-inner">
                   
                    <div id="main-wrapper">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-white" style="margin-bottom: 0px;">
                                    <div class="panel-heading clearfix">
                                        <h4 class="panel-title">All Complains</h4>
                                    </div>
                                    <div class="panel-body">
                                       <div class="table-responsive">
                                        <table id="example" class="display table" style="width: 100%; cellspacing: 0;">
                                            <thead>
                                                <tr>
                                                    <th>S_no.</th>
                                                    <th>Date</th>
                                                    <th>Sender</th>
                                                    <th>Complain</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>S_no.</th>
                                                    <th>Date</th>
                                                    <th>Sender</th>
                                                    <th>Complain</th>
                                                </tr>
                                            </tfoot>
<!--                                            <tbody>-->
                                                <%
                                                    int i=1;
                                                    MessageDAO dao=new MessageDAO();
                                                    List<MessageDTO> dto = dao.getAllComplains(username,"faculty");
                                                    Iterator<MessageDTO> itr=dto.iterator();
                                                        while(itr.hasNext())
                                                        {
                                                            MessageDTO user=itr.next();
                                                            
                                                %>
                                            
                                                <tr>
                                                    <td><%=i%></td>
                                                    <td><%=user.getDate()%></td>
                                                    <td><%=user.getSender()%></td>
                                                    <td><form action="hodDisplayComplainFaculty.jsp" method="post">
                                                <input type="hidden" value="<%=user.getId()%>" name="id">
                                                <button type="submit">view complain</button>
                                                    </form></td>
                                                </tr>
                                            
                                               <% i++;  
                                               } %>
                                              
<!--                                            </tbody>-->
                                           </table>  
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- Row -->
                    </div><!-- Main Wrapper -->
                    
                </div><!-- Page Inner -->
            </main><!-- Page Content -->
           
      

    
            </div>
        </div>
    </div>

    <script type="text/javascript">
    $(document).ready(function(){
      $('.nav_btn').click(function(){
        $('.mobile_nav_items').toggleClass('active');
      });
    });
    </script>

      <!-- Javascripts -->
      <script src="table/js/jquery-2.1.4.min.js"></script>
      <script src="table/js/jquery-ui.min.js"></script>
      <script src="table/js/jquery.slimscroll.min.js"></script>
      <script src="table/js/waves.min.js"></script>
      <script src="table/js/jquery.mockjax.js"></script>
      <script src="table/js/jquery.datatables.min.js"></script>
      <script src="table/js/bootstrap-editable.js"></script>
      <script src="table/js/table-data.js"></script>

  </body>
</html>