<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.connection.*"%>
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
      <script type="text/javascript" src="jsnew/jquery-1.9.1.min.js"></script>
   
        <script src="jsnew/highcharts.js"></script>

<script>
    <%        
    DecimalFormat df = new DecimalFormat("#.##");
    String acc=configuration_matrix.configuration_matrix_values_RF();
    System.out.println(acc);
    configuration_matrix.configuration_matrix_values_NB();
    configuration_matrix.configuration_matrix_values_ANN();
    %>
    

$(function () {
    $('#containergs').highcharts({
    	chart: {
            type: 'column'
        },
    	title: {
            text: 'Configuration Matrix System Info',
            x: -20 
        },
        subtitle: {
        	text: 'Parameters: X-Axies: Configuration Matrix Info',
            x: -20
        },
        xAxis: {
        	title: {
                text: 'Configuration Matrix Accuracy Info'
            },
            categories: ['RF','NB','ANN']
        },
        yAxis: {
            title: {
                text: 'Percentage %'
            },
            plotLines: [{
                value: 0,
                width: 0.5,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
        	
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Accuracy',
            data: [<%=configuration_matrix.rf_acc%>,<%=configuration_matrix.nb_acc%>,<%=configuration_matrix.nn_acc%>]
        }, {
            name: 'Precision',
            data: [<%=configuration_matrix.rf_pre%>,<%=configuration_matrix.nb_pre%>,<%=configuration_matrix.nn_pre%>]
        }, {
            name: 'Recall',
            data: [<%=configuration_matrix.rf_recall%>,<%=configuration_matrix.nb_recall%>,<%=configuration_matrix.nn_recall%>]
        }, {
            name: 'F-measure',
            data: [<%=configuration_matrix.rf_f1_score%>,<%=configuration_matrix.nb_f1_score%>,<%=configuration_matrix.nn_f1_score%>]
        }]
        
    });
});

</script>
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
                       
                        <div class="col-md-6 col-lg-3">
                        <div id="containergs" style="min-width: 810px; height: 500px; max-width: 800px; margin: 0 auto"></
                       
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