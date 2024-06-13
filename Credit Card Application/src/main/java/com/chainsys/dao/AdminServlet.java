package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.CreditCardDetails;
import com.chainsys.model.Details;
import com.chainsys.model.EmploymentDetails;
import com.chainsys.util.AccountRecords;
import com.chainsys.util.ApprovalRecords;
import com.chainsys.util.CardRecords;
import com.chainsys.util.EmploymentRecords;
import com.chainsys.util.Records;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CreditCardDetails card = new CreditCardDetails();
	Details details=new Details();
	EmploymentDetails employment= new EmploymentDetails();

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {

		case ("update"):
			int id = Integer.parseInt(request.getParameter("id"));
		String cardNumber=request.getParameter("card");
			System.out.println(id);
			card.setId(id);
			try {
				String retrievedMail=Records.readMail(id);
				System.out.println("Retreivedmail:"+retrievedMail);
				
				String message="Your Credit Card:"+cardNumber+"has been Approved";
				
				ApprovalRecords.approve(card);
				request.setAttribute("values", CardRecords.read());
				request.getRequestDispatcher("CreditCardApproval.jsp").forward(request, response);
				Mail.setProperties();
				Mail.setMailBody(retrievedMail, message);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			break;
			
			
		case("reject"):
			
			int customerId = Integer.parseInt(request.getParameter("id"));
		System.out.println(customerId);
		String cardNo=request.getParameter("card");

		card.setId(customerId);
		try {
			String retrievedMail=Records.readMail(customerId);
			System.out.println("Retreivedmail:"+retrievedMail);
			
			String message="Sorry!Your Credit Card:"+cardNo+"has been Rejected";
			
			ApprovalRecords.reject(card);
			request.setAttribute("values", CardRecords.read());
			request.getRequestDispatcher("CreditCardApproval.jsp").forward(request, response);
			Mail.setProperties();
			Mail.setMailBody(retrievedMail, message);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		break;
		
			

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ses=request.getSession();
		
		

		try {
//			ses.setAttribute("image", EmploymentRecords.read(details,employment));
			request.setAttribute("values", CardRecords.read());
//			byte[] incomeProof=EmploymentRecords.read(details, employment);
			request.setAttribute("incomeProof", EmploymentRecords.read(details, employment));
			request.getRequestDispatcher("CreditCardApproval.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
