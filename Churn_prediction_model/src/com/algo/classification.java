package com.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.Dbconn;

/**
 * Servlet implementation class classification
 */
@WebServlet("/classification")
public class classification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filetrain=request.getParameter("file1");
		String filetest=request.getParameter("file2");
		try {
			 int i=0;
			String train = Dbconn.trainarff_file+"\\"+filetrain;
			String test = Dbconn.testarff_file+"\\"+filetest;
			ClassifierRF rf=new ClassifierRF();
          rf.Executes(train, test);
          ClassifierNB nb=new ClassifierNB();
          nb.Execute(train, test);
          ClassifierANN ann=new ClassifierANN();
          ann.Execute(train, test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		PrintWriter out=response.getWriter();
		out.println("<script type=\"text/javascript\">");  
		out.println("alert('Classification Successfully');");  
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/File_ClassificationPage.jsp");
		rd.include(request, response);
		
	}

}
