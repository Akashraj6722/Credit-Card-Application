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
	
static	CreditCardDetails card = new CreditCardDetails();
static	Details details=new Details();
    
    public PinServlet() {
        super();
    }

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s= request.getSession();
		ArrayList<Details> list= (ArrayList<Details>)s.getAttribute("values");
		for(Details list1: list) {
		
			
        details.setCustomerID(list1.getCustomerID());
		card.setCardNumber(request.getParameter("cardNumber"));
		
		
		try {
			int pin=Integer.parseInt(request.getParameter("pin"));
			card.setPin(pin);
			if(CardRecords.check(card)==true) {
				
				CardRecords.update(card, details);
				response.sendRedirect("CustomerDetails.jsp");
			
			}else {
				//Sorry your card is not APPROVED yet
				response.sendRedirect("SetPin.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		}
	
	}

}
