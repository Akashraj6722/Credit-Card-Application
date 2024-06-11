package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.EmploymentDetails;
import com.chainsys.model.Details;
import com.chainsys.model.BankDetails;
import com.chainsys.model.CreditCardDetails;
import com.chainsys.util.AccountRecords;
import com.chainsys.util.CardEligibility;
import com.chainsys.util.CardRecords;
import com.chainsys.util.EmploymentRecords;
import com.chainsys.util.Records;
import com.chainsys.model.Details;


/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Details details = new Details();
	EmploymentDetails employment = new EmploymentDetails();
	CreditCardDetails card =new CreditCardDetails();
	BankDetails bankDetails=new BankDetails();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		HttpSession sess= request.getSession();
		
		ArrayList<Details> values1=(ArrayList<Details>) sess.getAttribute("values"); 
	     for(Details display:values1){
	    	 
	    	String fName = display.getfName();
	    	String lName =  display.getlName();
	    	 
	    	card.setHolderName(fName+" "+lName);
	    	 
	    	 employment.setOccupation(request.getParameter("occupation"));
	    
	    	 employment.setCompanyname(request.getParameter("companyName"));
	    	 employment.setDesignation(request.getParameter("designation"));
        
		Long income=Long.parseLong(request.getParameter("annualIncome"));
		employment.setIncome(income);
		
		
	
		try {
			Records.readSpecific(display);//to get customer id
			AccountRecords.read(display, bankDetails);  //to get account number 
			EmploymentRecords.insert(employment, details);
			
			System.out.println("employYY");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
		
		if(income>200000 && income<400000) {
			System.out.println("You are eligible for Silver Card");
			
			card.setCardNumber(NumberGeneration.rupayCardNumber());
			card.setCvvNumber(NumberGeneration.ccvNumber());
			
			
			YearMonth ym=YearMonth.now();
			String date=ym.toString();
			System.out.println(date);
			card.setCardAppliedDate(date);

			
			String valid=ym.plusYears(3).toString();
			System.out.println(valid);
			card.setValidity(valid);
			card.setCardType("silver");
			
			try {
				CardRecords.insert(card, display, bankDetails);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
			request.setAttribute("values",PreviewDetails.display(card));
			request.getRequestDispatcher("PreviewSilver.jsp").forward(request, response);
			

			
//			response.sendRedirect("CardSilver.jsp");
		
		}else if(income>400000  && income<600000){
			System.out.println("You are eligible for Gold Card");
			response.sendRedirect("CardGold.jsp");

			
		}else if(income>600000  && income<800000){
		
			System.out.println("You are eligible for Platinum Card");
			response.sendRedirect("CardPlatinum.jsp");

		
	}else if(income>800000  ){
		System.out.println("You are eligible for Elite Card");
		response.sendRedirect("CardElite.jsp");


	}else {
		
		System.out.println("Sorry! You're Income does'nt meet our minimum requirements");
		
	}
		
		
	
		
		
	}

}
}
