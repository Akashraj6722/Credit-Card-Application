package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.CreditCardDetails;
import com.chainsys.model.Details;
import com.chainsys.util.CardRecords;


@WebServlet("/PinServlet")
public class PinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CreditCardDetails card = new CreditCardDetails();
	Details details=new Details();
    
    public PinServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s= request.getSession();
		ArrayList<Details> list= (ArrayList<Details>)s.getAttribute("values");
		for(Details list1: list) {
		
			
			System.out.println("pinServlet:customer's ID"+list1.getCustomerID());
        details.setCustomerID(list1.getCustomerID());
		card.setCardNumber(request.getParameter("cardNumber"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		card.setPin(pin);
		
		try {
			System.out.println(CardRecords.check(card));
			if(CardRecords.check(card)==true) {
				
				CardRecords.update(card, details);
				response.sendRedirect("CustomerDetails.jsp");
			
			}else {
				System.out.println("Sorry your card is not APPROVED yet");
				response.sendRedirect("SetPin.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
	
	}

}
