<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.ManagementDTO"%>
<%@page import="dao.ManagementDAO"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complain HOD</title>
    <link rel="shortcut icon" href="img/title.png" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="css/nstyle.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
    
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<style type="text/css">
.email-app {
    display: flex;
    flex-direction: row;
    background: #fff;
    border: 1px solid black;
}

@media (min-width: 992px){  
.bootdey {
    max-width: 960px;
}
}

.row{
    justify-content: center;
}
.email-app main {
    min-width: 0;
    flex: 1;
    padding: 1rem;
}


@media (max-width: 767px) {
    .email-app {
        flex-direction: column;
    }
    
}


</style>
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
              <li class="breadcrumb-item active" aria-current="page">SEND NOTICE</li>
            </ol>
              </nav>
              <!-- /Breadcrumb -->
      
              <div class="container bootdey">
<div class="email-app">
    
    <main>
        <p class="text-center"><b>NOTICE TO STUDENT</b></p>
        <form action="HODSendNoticeStudentServlet" method="post">
            <input type="hidden" value="<%=username%>" name="rid">
        <div class="row">
            <div class="col-sm-11">
                
                <div class="form-group mt-4">
                    <textarea class="form-control" id="message" name="message" rows="8" placeholder="Type your Message"></textarea>
                </div>
                <div class="form-group">
                    <center><button type="submit" class="btn btn-success">Send</button>
                    <button type="reset" class="btn btn-danger">Discard</button></center>
                </div>
            </div>
        </div>
      </form>
    </main>
</div>
</div>

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

    <script type="text/javascript">
        var text_max = 200;
        $('#count_message').html(text_max + ' remaining');
          $('#text').keyup(function() {
          var text_length = $('#text').val().length;
          var text_remaining = text_max - text_length;
          $('#count_message').html(text_remaining + ' remaining');
        });
    </script>
  </body>
</html>



