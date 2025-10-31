package com.fileprocess;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class generate_arff
 */
@WebServlet("/generate_arff")
public class generate_arff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generate_arff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		arff_create.Trainarff();
		arff_create.Testarff();
	} catch (Exception ex) {
        System.out.println(ex);
    }
	PrintWriter out=response.getWriter();
	out.println("<script type=\"text/javascript\">");  
	out.println("alert('Arff File Create Successfully');");  
	out.println("</script>");
	RequestDispatcher rd = request.getRequestDispatcher("/AdminHomePage.jsp");
	rd.include(request, response);
	}

}
