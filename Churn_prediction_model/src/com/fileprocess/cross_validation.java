package com.fileprocess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Dbconn;

/**
 * Servlet implementation class cross_validation
 */
@WebServlet("/cross_validation")
public class cross_validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cross_validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Connection con;
            Dbconn db = new Dbconn();
            con = db.conn();
            Statement st1 = (Statement) con.createStatement();
            Statement st4 = (Statement) con.createStatement();
            ResultSet rs1 = st1.executeQuery("select * from chrundata");
            ResultSet rs = st4.executeQuery("select * from chrundata");
          //  st4.executeUpdate("truncate table traindata");
            //st4.executeUpdate("truncate table testdata");
            int count = 0;
            while (rs1.next()) {
                count = count + 1;
            }
            int get70 = (count / 100) * 70;
            int get30 = count - get70;
            int counter = 0;
            while (rs.next()) {
                Statement st2 = (Statement) con.createStatement();
                Statement st3 = (Statement) con.createStatement();
                String datalabel = "";
                if (counter < get70) {
                   
                    String Query = "insert into traindata (State,Account_length,Area_code,International_plan,Voice_mail_plan,Number_vmail_messages,Total_day_minutes,Total_day_calls,Total_day_charge,Total_eve_minutes,Total_eve_calls,Total_eve_charge,Total_night_minutes,Total_night_calls,Total_night_charge,Total_intl_minutes,Total_intl_calls,Total_intl_charge,Customer_service_calls,Churn_Label) values( '" + rs.getString(1) + "','" + rs.getString(2) + "','" + rs.getString(3) + "','" + rs.getString(4) + "','" + rs.getString(5) + "','" + rs.getString(6) + "','" + rs.getString(7) + "','" + rs.getString(8) + "','" + rs.getString(9) + "','" + rs.getString(10) + "','" + rs.getString(11) + "','" + rs.getString(12) + "','" + rs.getString(13) + "','" + rs.getString(14) + "','" + rs.getString(15) + "','" + rs.getString(16) + "','" + rs.getString(17) + "','" + rs.getString(18) + "','" + rs.getString(19) + "','" + rs.getString(20) + "')";
                    st2.executeUpdate(Query);

                } else {
                    
                    String Query = "insert into testdata (State,Account_length,Area_code,International_plan,Voice_mail_plan,Number_vmail_messages,Total_day_minutes,Total_day_calls,Total_day_charge,Total_eve_minutes,Total_eve_calls,Total_eve_charge,Total_night_minutes,Total_night_calls,Total_night_charge,Total_intl_minutes,Total_intl_calls,Total_intl_charge,Customer_service_calls,Churn_Label) values( '" + rs.getString(1) + "','" + rs.getString(2) + "','" + rs.getString(3) + "','" + rs.getString(4) + "','" + rs.getString(5) + "','" + rs.getString(6) + "','" + rs.getString(7) + "','" + rs.getString(8) + "','" + rs.getString(9) + "','" + rs.getString(10) + "','" + rs.getString(11) + "','" + rs.getString(12) + "','" + rs.getString(13) + "','" + rs.getString(14) + "','" + rs.getString(15) + "','" + rs.getString(16) + "','" + rs.getString(17) + "','" + rs.getString(18) + "','" + rs.getString(19) + "','" + rs.getString(20) + "')";
                    st3.executeUpdate(Query);

                }
                counter = counter + 1;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Cross Validation Successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/AdminHomePage.jsp");
		rd.include(request, response);
	}

}
