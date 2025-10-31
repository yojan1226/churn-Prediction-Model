package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login_page
 */
@WebServlet("/login_page")
public class login_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_page() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('You are successfully logged out!');");
		out.println("</script>");
		request.getRequestDispatcher("Login_Page.jsp").include(request, response);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		String uname = request.getParameter("txt_Uname");
		String password = request.getParameter("txt_Password");
		
		System.out.println("EmailId=>"+uname+"\t Password=>"+password);
		
			if (uname.equals("admin@gmail.com") && password.equals("admin")) {
				session.setAttribute("bemail", "Admin");
				pw.println("<script> alert('Login Successfuly');</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/File_UploadPage.jsp");
				rd.include(request, response);
			} else {
				response.sendRedirect("index.jsp");
			}
	}

}
