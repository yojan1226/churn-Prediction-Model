package com.fileprocess;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.Dbconn;

/**
 * Servlet implementation class file_upload
 */
@WebServlet("/file_upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class file_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public file_upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("txt_search");
		InputStream inputStream = null;
		try {
			int i = 0;
			inputStream = filePart.getInputStream();
			Connection con = Dbconn.conn();
			String line;
			Statement st1 = (Statement) con.createStatement();
			Statement st4 = (Statement) con.createStatement();
             st4.executeUpdate("truncate table chrundata");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (i == 0) {
					i++;
				} else {
					String val1 = NLP_Process.StateProcess(con, parts[0]);
					String val2 = NLP_Process.Account_lengthProcess(con,
							parts[1]);
					String val3 = NLP_Process.Area_codeProcess(con, parts[2]);
					String val4 = NLP_Process.International_planProcess(con,
							parts[3]);
					String val5 = NLP_Process.Voice_mail_planProcess(con,
							parts[4]);
					String val6 = NLP_Process.Number_vmail_messagesProcess(con,
							parts[5]);
					String val7 = NLP_Process.Total_day_minutesProcess(con,
							parts[6]);
					String val8 = NLP_Process.Total_day_callsProcess(con,
							parts[7]);
					String val9 = NLP_Process.Total_day_chargeProcess(con,
							parts[8]);
					String val10 = NLP_Process.Total_eve_minutesProcess(con,
							parts[9]);
					String val11 = NLP_Process.Total_eve_callsProcess(con,
							parts[10]);
					String val12 = NLP_Process.Total_eve_chargeProcess(con,
							parts[11]);
					String val13 = NLP_Process.Total_night_minutesProcess(con,
							parts[12]);
					String val14 = NLP_Process.Total_night_callsProcess(con,
							parts[13]);
					String val15 = NLP_Process.Total_night_chargeProcess(con,
							parts[14]);
					String val16 = NLP_Process.Total_intl_minutesProcess(con,
							parts[15]);
					String val17 = NLP_Process.Total_intl_callsProcess(con,
							parts[16]);
					String val18 = NLP_Process.Total_intl_chargeProcess(con,
							parts[17]);
					String val19 = NLP_Process.Customer_service_callsProcess(
							con, parts[18]);
					String val20 = NLP_Process.Churn_LabelProcess(con,
							parts[19]);
					if (val1.equals("0") || val2.equals("0")
							|| val3.equals("0") || val4.equals("0")
							|| val5.equals("0") || val6.equals("0")
							|| val7.equals("0") || val8.equals("0")
							|| val9.equals("0") || val10.equals("0")
							|| val11.equals("0") || val12.equals("0")
							|| val13.equals("0") || val14.equals("0")
							|| val15.equals("0") || val16.equals("0")
							|| val16.equals("0") || val18.equals("0")
							|| val17.equals("0") || val19.equals("0")||val20.equals("0")) {
					} else {
						String Query = "insert into chrundata(State,Account_length,Area_code,International_plan,Voice_mail_plan,Number_vmail_messages,Total_day_minutes,Total_day_calls,Total_day_charge,Total_eve_minutes,Total_eve_calls,Total_eve_charge,Total_night_minutes,Total_night_calls,Total_night_charge,Total_intl_minutes,Total_intl_calls,Total_intl_charge,Customer_service_calls,Churn_Label) values('"
								+ parts[0]
								+ "','"
								+ parts[1]
								+ "','"
								+ parts[2]
								+ "','"
								+ parts[3]
								+ "','"
								+ parts[4]
								+ "','"
								+ parts[5]
								+ "','"
								+ parts[6]
								+ "','"
								+ parts[7]
								+ "','"
								+ parts[8]
								+ "','"
								+ parts[9]
								+ "','"
								+ parts[10]
								+ "','"
								+ parts[11]
								+ "','"
								+ parts[12]
								+ "','"
								+ parts[13]
								+ "','"
								+ parts[14]
								+ "','"
								+ parts[15]
								+ "','"
								+ parts[16]
								+ "','"
								+ parts[17]
								+ "','"
								+ parts[18] + "','" + parts[19] + "')";
						st1.executeUpdate(Query);
					}
				}
			}// end while loop
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Upload Data Set Successfully');");
		out.println("</script>");
		RequestDispatcher rd = request
				.getRequestDispatcher("/File_UploadPage.jsp");
		rd.include(request, response);
	}

	public static int preprocess() {
		int msg = 0;

		return msg;
	}
}
