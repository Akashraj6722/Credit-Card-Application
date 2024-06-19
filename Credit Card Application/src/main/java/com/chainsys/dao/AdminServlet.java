package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.model.CreditCardDetails;
import com.chainsys.model.Details;
import com.chainsys.model.EmploymentDetails;
import com.chainsys.util.ApprovalRecords;
import com.chainsys.util.CardRecords;
import com.chainsys.util.EmploymentRecords;
import com.chainsys.util.Records;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String  CREDITCARDAPPROVAL= "CreditCardApproval.jsp";
	static CreditCardDetails card = new CreditCardDetails();
	static Details details=new Details();
	static EmploymentDetails employment= new EmploymentDetails();
	

	public AdminServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		try {
			request.setAttribute("incomeProof", EmploymentRecords.read());
			request.setAttribute("values", CardRecords.read());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

		switch (action) {

		case ("update"):
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				String cardNumber=request.getParameter("card");
					card.setId(id);
				String retrievedMail=Records.readMail(id);
				
				String message="Your Credit Card:"+cardNumber+"has been Approved";
				
				ApprovalRecords.approve(card);
				
				request.getRequestDispatcher(CREDITCARDAPPROVAL).forward(request, response);
				Mail.setProperties();
				Mail.setMailBody(retrievedMail, message);
				
			} catch (ClassNotFoundException | SQLException | MessagingException e) {
				e.printStackTrace();
			} 

			break;
			
			
		case("reject"):
			
			
		try {
			int customerId = Integer.parseInt(request.getParameter("id"));
			String cardNo=request.getParameter("card");

			card.setId(customerId);
			String retrievedMail=Records.readMail(customerId);
			
			String message="Sorry!Your Credit Card:"+cardNo+"has been Rejected";
			
			ApprovalRecords.reject(card);
			
			request.getRequestDispatcher(CREDITCARDAPPROVAL).forward(request, response);
			Mail.setProperties();
			Mail.setMailBody(retrievedMail, message);
			
		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			e.printStackTrace();
		} 

		break;
		default:
			
			break;
			

		}
		

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		try {
			request.setAttribute("values", CardRecords.read());
			request.setAttribute("incomeProof", EmploymentRecords.read());
			request.getRequestDispatcher(CREDITCARDAPPROVAL).forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
