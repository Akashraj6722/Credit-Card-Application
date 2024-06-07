package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.BankDetails;
import com.chainsys.model.Details;
import com.chainsys.util.AccountRecords;
import com.chainsys.util.Records;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Details details=new Details(); 
	BankDetails bankDetails = new BankDetails();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String phone=request.getParameter("ph");
		String password=request.getParameter("pass");
		
		details.setPhone(phone);
		details.setPassword(password);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("phoneNumber", details.getPhone());
		
		System.out.println(details.getPhone());
		
		try {
			if(Records.check(details)==true) {
				
				/* request.setAttribute("values", Records.read(details)); */
				session.setAttribute("values", Records.read(details));
				request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);

//				response.sendRedirect("CustomerDetails.jsp");
//				HttpSession session=request.getSession();
//				 session.setAttribute("phone", phone);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  
		
		System.out.println("post");
//		 System.out.println(details.getCustomerID());
//		 
//	
		 System.out.println("after Post: "+details.getCustomerID());


		try {
			request.setAttribute("info", AccountRecords.read(details, bankDetails));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);

		
//		HttpSession session=request.getSession(false);
//		
//		if(session!=null) {
//			
//			session.invalidate();
//		}
//		
//		
//		 response.sendRedirect("MainPage.jsp");

	}

}
