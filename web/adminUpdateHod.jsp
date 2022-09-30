<%@page import="dto.StudentDTO"%>
<%@page import="dao.StudentDAO"%>
<%@page import="dto.ManagementDTO"%>
<%@page import="dao.ManagementDAO"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update HOD</title>
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
    if(username ==null || !(category.equals("admin")))
    {
        response.sendRedirect("login.jsp");
    }
%>
<%
    String id=request.getParameter("id");
    ManagementDAO user=new ManagementDAO();
    ManagementDTO dtouser=user.getUserData(id);
    
    if((dtouser.getUsername())==null)
    {
         response.sendRedirect("getAddHodId.jsp");
    }
%>
    <input type="checkbox" id="check">
    <!--header area start-->
    <header>
      <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
      </label>
      <div class="left_area">
        <h3>ADMIN <span>PAGE</span></h3>
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
        <a href="adminHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Add New &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminAddHod.jsp"><i class="fas fa-table"></i><span>HOD</span></a>
            <a href="adminAddFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="adminAddStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Update &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminUpdateProfile.jsp"><i class="fas fa-th"></i><span>Profile</span></a>
            <a href="getAddHodId.jsp"><i class="fas fa-table"></i><span>HOD Details</span></a>
            <a href="getAddFacultyId.jsp"><i class="fas fa-th"></i><span>Faculty Details</span></a>
            <a href="getAddStudentId.jsp"><i class="fas fa-th"></i><span>Student Details</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Delete &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminDeleteHod.jsp"><i class="fas fa-table"></i><span>HOD Details</span></a>
            <a href="adminDeleteFaculty.jsp"><i class="fas fa-th"></i><span>Faculty Details</span></a>
            <a href="adminDeleteStudent.jsp"><i class="fas fa-th"></i><span>Student Details</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Display All &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminDisplayHod.jsp"><i class="fas fa-table"></i><span>HOD</span></a>
            <a href="adminDisplayFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="adminDisplayStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
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
      <a href="adminHome.jsp"><i class="fas fa-desktop"></i><span>Profile</span></a>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Add New &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminAddHod.jsp"><i class="fas fa-table"></i><span>HOD</span></a>
            <a href="adminAddFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="adminAddStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Update &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminUpdateProfile.jsp"><i class="fas fa-th"></i><span>Profile</span></a>
            <a href="getAddHodId.jsp"><i class="fas fa-table"></i><span>HOD Details</span></a>
            <a href="getAddFacultyId.jsp"><i class="fas fa-th"></i><span>Faculty Details</span></a>
            <a href="getAddStudentId.jsp"><i class="fas fa-th"></i><span>Student Details</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Delete &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminDeleteHod.jsp"><i class="fas fa-table"></i><span>HOD Details</span></a>
            <a href="adminDeleteFaculty.jsp"><i class="fas fa-th"></i><span>Faculty Details</span></a>
            <a href="adminDeleteStudent.jsp"><i class="fas fa-th"></i><span>Student Details</span></a>
          </div>
      </div>
      <div class="show1">
        <a href="#"><i class="fas fa-cogs" ></i><span>Display All &nbsp; &nbsp;<i class="fas fa-chevron-down"></i></span></a>
          <div class="hide1">
            <a href="adminDisplayHod.jsp"><i class="fas fa-table"></i><span>HOD</span></a>
            <a href="adminDisplayFaculty.jsp"><i class="fas fa-th"></i><span>Faculty</span></a>
            <a href="adminDisplayStudent.jsp"><i class="fas fa-th"></i><span>Student</span></a>
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
              <li class="breadcrumb-item"><a href="javascript:void(0)">ADMIN</a></li>
              <li class="breadcrumb-item active" aria-current="page">UPDATE HOD</li>
            </ol>
              </nav>
              <!-- /Breadcrumb -->
<form action="AdminUpdateHODServlet" method="post">  
              <div class="container">
                <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                <div class="addcard h-100">
                  <div class="card-body">
                    <div class="account-settings">
                      <div class="user-profile">
                        <div class="user-avatar">
                          <img src="1.png" alt="Maxwell Admin">
                        </div>
                      </div>
                      <div class="about">
                          <a href="#" style="text-decoration: none;"><button type="button" class="btn btn-primary">Upload Profile</button></a>
                      </div>
                    </div>
                  </div>
                </div>
                </div>                    
                <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                <div class="addcard h-100">
                  <div class="card-body">
                    <div class="row gutters">
                      <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h6 class="mb-2 text-primary">Basic Details</h6>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <input type="hidden" value="<%=id%>" name="id">
                          <label for="fullName">Full Name</label>
                          <input type="text" class="form-control" name="name" value="<%=dtouser.getUsername()%>" id="fullName" placeholder="Enter full name" required>
                        </div>
                      </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                            <label class="form-group" >Gender</label><br>
                          <input type="radio"  name="gender" value="male" id="gender" required>
                          <label for="gender" style="color:grey;">Male</label>&nbsp;&nbsp;
                          <input type="radio"  name="gender" value="female" id="gender" required>
                          <label for="gender" style="color:grey;">Female</label>&nbsp;&nbsp;
                          <input type="radio"  name="gender" value="other" id="gender" required>
                          <label for="gender" style="color:grey;">Other</label>
                        </div>
                      </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="department">Department</label>
                          <select id="department" name="department" class="form-control" required>
                            <option value="">--Select--</option>
                            <option value="Computer_Science">Computer Science</option>
                            <option value="Information_Technology">Information Technology</option>
                            <option value="Mechanical_Engineering">Mechanical Engineering</option>
                            <option value="Chemical_Engineering">Chemical Engineering</option>
                            <option value="Civil_Engineering">Civil Engineering</option>
                            <option value="Electronics_and_communication_Engineering">Electronics and communication Engineering</option>
                          </select>
                         </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="designation">Designation</label>
                          <input type="text" class="form-control" name="designation" value="<%=dtouser.getDesignation()%>" id="designation" placeholder="Enter designation" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="eMail">Email</label>
                          <input type="email" class="form-control" name="email" value="<%=dtouser.getEmail()%>" id="eMail" placeholder="Enter email ID" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="phone">Contact</label>
                          <input type="text" class="form-control" name="contact" value="<%=dtouser.getContact()%>" id="phone" placeholder="Enter phone number" required>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </div>
                </div>
              </div><br>
              <div class="container">
                <div class="row gutters">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="addcard h-100">
                  <div class="card-body">
                    <div class="row gutters">
                      <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h6 class="mb-2 text-primary">Additional Details</h6>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="year">Joining Year</label>
                          <input type="text" class="form-control" name="year" value="<%=dtouser.getYear()%>" id="year" placeholder="YYYY" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="qualification">Qualification</label>
                          <input type="text" class="form-control" id="qualification" name="qualification" value="<%=dtouser.getQualification()%>" placeholder="Enter qualification" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="experience">Experience</label>
                          <input type="text" class="form-control" id="experience" name="experience" value="<%=dtouser.getExperience()%>" placeholder="Enter experience" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="address">Address</label>
                          <input type="text" class="form-control" id="address" name="address" value="<%=dtouser.getAddress()%>" placeholder="Enter address" required>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="aadhar">Aadhar No.</label>
                          <input type="text" class="form-control" name="aadhar" value="<%=dtouser.getAadhar()%>" id="aadhar" placeholder="Enter aadhar number" required>
                        </div>
                      </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="blood">Blood Group</label>
                          <select id="blood" name="blood" class="form-control" required>
                            <option value="">--Select--</option>
                            <option value="A+">A+</option>
                            <option value="B+">B+</option>
                            <option value="AB+">AB+</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                            <option value="A-">A-</option>
                            <option value="B-">B-</option>
                            <option value="AB-">AB-</option>
                          </select>
                        </div>
                      </div>
                      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <div class="form-group">
                          <label for="dob">DOB</label>
                          <input type="date" class="form-control" name="dob" value="<%=dtouser.getDob()%>" id="dob" placeholder="Enter DOB" required>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </div>
                </div>
              </div>
                <br><center>
                  <button type="submit" id="submit" name="submit" class="btn btn-primary">Update</button>
                  <a href="adminHome.jsp" style="text-decoration: none;"><button type="reset" id="submit" name="submit" class="btn btn-secondary">Cancel</button></a>
              </center>   
</form>                
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