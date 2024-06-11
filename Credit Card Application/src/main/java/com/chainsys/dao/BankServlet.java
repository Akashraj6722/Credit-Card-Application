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
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Details details=new Details();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		try {
			request.setAttribute("values", Records.read(details));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Details details=new Details();
		BankDetails bankDetails=new BankDetails();
		
		
		details.setfName(request.getParameter("fName"));
		details.setlName(request.getParameter("lName"));
		details.setDob(request.getParameter("DOB"));
		details.setAadhaar(request.getParameter("aadhaar"));
		details.setPan(request.getParameter("pan"));
		details.setMail(request.getParameter("mail"));
		details.setPhone(request.getParameter("ph"));
		
		
		details.setPassword(request.getParameter("pass"));
		
		bankDetails.setAccountNumber(NumberGeneration.accountNumber());
		bankDetails.setIfsc(NumberGeneration.ifsc());
		
		
		
	
		try {
			Records.insert(details);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Records.read(details);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			AccountRecords.insert(details,bankDetails);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			AccountRecords.read(details, bankDetails);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

		
		response.sendRedirect("MainPage.jsp");
		
	}
}
