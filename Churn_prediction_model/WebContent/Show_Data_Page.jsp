<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.Dbconn"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Application</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- site icon -->
      <link rel="icon" href="images/fevicon.png" type="image/png" />
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css" />
      <!-- site css -->
      <link rel="stylesheet" href="style.css" />
      <!-- responsive css -->
      <link rel="stylesheet" href="css/responsive.css" />
      <!-- color css -->
      <link rel="stylesheet" href="css/colors.css" />
      <!-- select bootstrap -->
      <link rel="stylesheet" href="css/bootstrap-select.css" />
      <!-- scrollbar css -->
      <link rel="stylesheet" href="css/perfect-scrollbar.css" />
      <!-- custom css -->
      <link rel="stylesheet" href="css/custom.css" />
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body class="dashboard dashboard_1">
      <div class="full_container">
         <div class="inner_container">
            <!-- Sidebar  -->
            <nav id="sidebar">
               <div class="sidebar_blog_1">
                  <div class="sidebar-header">
                     <div class="logo_section">
                        <a href="index.html"><img class="logo_icon img-responsive" src="images/logo/logo_icon.png" alt="#" /></a>
                     </div>
                  </div>
                  <div class="sidebar_user_info">
                     <div class="icon_setting"></div>
                     <div class="user_profle_side">
                       
                        Project Application
                     </div>
                  </div>
               </div>
               <div class="sidebar_blog_2">
                  <h4>General</h4>
                  <ul class="list-unstyled components">
                     <li>
                        <a href="File_UploadPage.jsp"><i class="fa fa-dashboard yellow_color"></i> <span>Upload Dataset</span></a>
                         </li>
                     
                     <li><a href="Show_Data_Page.jsp"><i class="fa fa-table purple_color2"></i> <span>View Data</span></a></li>
                     <li>
                        <a href="cross_validation" ><i class="fa fa-object-group blue2_color"></i> <span>Cross Validation</span></a>
                        
                     </li>
                     <li><a href="generate_arff"><i class="fa fa-briefcase blue1_color"></i> <span>Generate ARFF</span></a></li>
                    
                     <li class="active">
                        <a href="File_ClassificationPage.jsp" ><i class="fa fa-clone yellow_color"></i> <span>Classification (ML)</span></a>
                       
                     </li>
                     <li><a href="Analysis_Page.jsp"><i class="fa fa-bar-chart-o green_color"></i> <span>Analysis</span></a></li>
                      </ul>
                  
                  
                    </div>
            </nav>
            <!-- end sidebar -->
            <!-- right content -->
            <div id="content">
               <!-- topbar -->
               <div class="topbar">
                  <nav class="navbar navbar-expand-lg navbar-light">
                     <div class="full">
                        <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
                        <div class="logo_section">
                          <span class="name_user">Churn Prediction using Machine Learning</span>
                               </div>
                        <div class="right_topbar">
                           <div class="icon_info">
                             
                              <ul class="user_profile_dd">
                                 <li>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="login_page">
                                    <img class="img-responsive rounded-circle" src="images/layout_img/user_img.jpg" alt="#" /><span class="name_user"><%=session.getAttribute("bemail") %></span></a>
                                    <div class="dropdown-menu">
                                      
                                       <a class="dropdown-item" href="login_page"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                                    </div>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </nav>
               </div>
               <!-- end topbar -->
               <!-- dashboard inner -->
               <div class="midde_cont">
                  <div class="container-fluid">
                     <div class="row column_title">
                        <div class="col-md-12">
                           <div class="page_title">
                              <h2>Dashboard</h2>
                           </div>
                        </div>
                     </div>
                     <div class="row column1">
                        <div class="col-md-12">
                           <div class="white_shd full margin_bottom_30">
                              <div class="full graph_head">
                                 <div class="heading1 margin_0">
                                    <h2>Project <small>( Listing Design )</small></h2>
                                 </div>
                              </div>
                              <div class="full price_table padding_infor_info">
                                 <div class="row">
                                    <div class="col-lg-12">
                                       <div class="table-responsive-sm">
                                          <table class="table table-striped projects">
                                             <thead class="thead-dark">
                                                <tr>
                                                   <th style="width: 2%">State</th>
                                                   <th style="width: 30%">Account_length</th>
                                                   <th>Area_code</th>
                                                   <th>International_plan</th>
                                                   <th>Voice_mail_plan</th>
                                                   
                                                   <th>Number_vmail_messages</th>
                                                   <th>Total_day_minutes</th>
                                                   <th>Total_day_calls</th>
                                                   <th>Total_day_charge</th>
                                                   <th>Total_eve_minutes</th>
                                                   <th>Total_eve_calls</th>
                                                   <th>Total_eve_charge</th>
                                                   <th>Total_night_minutes</th>
                                                   <th>Total_night_calls</th>
                                                   <th>Total_night_charge</th>
                                                   <th >Total_intl_minutes</th>
                                                   <th >Total_intl_calls</th>
                                                   <th>Total_intl_charge</th>
                                                   <th>Customer_service_calls</th>
                                                   <th>Churn_Label</th>
                                                </tr>
                                             </thead>
                                             <tbody>
                                                <%
											Connection con = Dbconn.conn();
											Statement stat1 = con.createStatement();
											String qrry1 = "select * from chrundata";
											ResultSet rs1 = stat1.executeQuery(qrry1);
											while (rs1.next()) {
										%>
										<tr>
											<td><%=rs1.getString(1)%></td>
											<td><%=rs1.getString(2)%></td>
											<td><%=rs1.getString(3)%></td>
											<td><%=rs1.getString(4)%></td>
											<td><%=rs1.getString(5)%></td>
											<td><%=rs1.getString(6)%></td>
											<td><%=rs1.getString(7)%></td>
											<td><%=rs1.getString(8)%></td>
											<td><%=rs1.getString(9)%></td>
											<td><%=rs1.getString(10)%></td>
											<td><%=rs1.getString(11)%></td>
											<td><%=rs1.getString(12)%></td>
											<td><%=rs1.getString(13)%></td>
											<td><%=rs1.getString(14)%></td>
											<td><%=rs1.getString(15)%></td>
											<td><%=rs1.getString(16)%></td>
											<td><%=rs1.getString(17)%></td>
											<td><%=rs1.getString(18)%></td>
											<td><%=rs1.getString(19)%></td>
											<td><%=rs1.getString(20)%></td>

										</tr>
										<%
											}
										%>

                                             </tbody>
                                          </table>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                       </div>
                  <!-- footer -->
                  <div class="container-fluid">
                     <div class="footer">
                        <p>Copyright © 2023 Designed by html.design. All rights reserved.<br><br>
                           
                        </p>
                     </div>
                  </div>
               </div>
               <!-- end dashboard inner -->
            </div>
         </div>
      </div>
      <!-- jQuery -->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <!-- wow animation -->
      <script src="js/animate.js"></script>
      <!-- select country -->
      <script src="js/bootstrap-select.js"></script>
      <!-- owl carousel -->
      <script src="js/owl.carousel.js"></script> 
      <!-- chart js -->
      <script src="js/Chart.min.js"></script>
      <script src="js/Chart.bundle.min.js"></script>
      <script src="js/utils.js"></script>
      <script src="js/analyser.js"></script>
      <!-- nice scrollbar -->
      <script src="js/perfect-scrollbar.min.js"></script>
      <script>
         var ps = new PerfectScrollbar('#sidebar');
      </script>
      <!-- custom js -->
      <script src="js/custom.js"></script>
      <script src="js/chart_custom_style1.js"></script>
   </body>
</html>