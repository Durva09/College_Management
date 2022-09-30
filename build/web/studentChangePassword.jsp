<%@page import="dto.ManagementDTO"%>
<%@page import="dao.ManagementDAO"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Existing Password</title>
    <link rel="shortcut icon" href="img/title.png" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="css/nstyle.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>
<%
    String username=(String)session.getAttribute("username");
    String category=(String)session.getAttribute("category");
    if(username ==null || !(category.equals("student")))
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
        <h3> Student <span>PAGE</span></h3>
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
        <a href="studentHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="studentUpdateProfile.jsp"><i class="fas fa-cogs" ></i><span>Update Profile&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="studentChangePassword.jsp"><i class="fas fa-cogs" ></i><span>Change Password&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Complain &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="studentComplainFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentComplainHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
          </div>
      </div>
       <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Notice &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
        <div class="hide1">
            <a href="studentNoticeFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentNoticeHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
        </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Assignment <i class="fas fa-chevron-down"></i></span></a>
        <div class="hide1">
            <a href="studentAssignmentFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentAssignmentHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
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
       <a href="studentHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="studentUpdateProfile.jsp"><i class="fas fa-cogs" ></i><span>Update Profile&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="studentChangePassword.jsp"><i class="fas fa-cogs" ></i><span>Change Password&nbsp; &nbsp;</span></a>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Complain &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="studentComplainFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentComplainHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
          </div>
      </div>
       <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Notice &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
        <div class="hide1">
            <a href="studentNoticeFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentNoticeHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
        </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Check Assignment <i class="fas fa-chevron-down"></i></span></a>
        <div class="hide1">
            <a href="studentAssignmentFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="studentAssignmentHod.jsp"><i class="fas fa-th"></i><span>HOD</span></a>
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
              <li class="breadcrumb-item"><a href="javascript:void(0)">STUDENT</a></li>
              <li class="breadcrumb-item active" aria-current="page">EXISTING PASSWORD</li>
            </ol>
              </nav>
              <!-- /Breadcrumb -->
      
              <section class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="content">
                                <form action="StudentCheckPasswordServlet" method="post">
                                    <h2>Enter Existing Password</h2>
                                    <div class="input-group">
                                        <input type="password" class="form-control" name="current" placeholder="Enter Existing Password">
                                        <span class="input-group-btn">
                                            <button class="btn" type="submit">Submit</button>
                                        </span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

    
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

  </body>
</html>