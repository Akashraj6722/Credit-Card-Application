package com.chainsys.dao;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.CardDetails;
import com.chainsys.model.Details;
import com.chainsys.model.PreviewCard;
import com.chainsys.util.CardEligibility;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CardDetails card = new CardDetails();
	PreviewCard preview =new PreviewCard();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		HttpSession sess= request.getSession();
		
		ArrayList<Details> values1=(ArrayList<Details>) sess.getAttribute("values"); 
	     for(Details display:values1){
	    	 
	    	String fName = display.getfName();
	    	String lName =  display.getlName();
	    	 
	    	 preview.setHolderName(fName+" "+lName);
	    	 
	    	 card.setOccupation(request.getParameter("occupation"));
	    
		card.setCompanyname(request.getParameter("companyName"));
		card.setDesignation(request.getParameter("deignation"));
        
		Long income=Long.parseLong(request.getParameter("annualIncome"));
		card.setIncome(income);
		
	
		
		
		
		
		if(income>200000 && income<400000) {
			System.out.println("You are eligible for Silver Card");
			
			preview.setCardNumber(NumberGeneration.rupayCardNumber());
			preview.setCvvNumber(NumberGeneration.ccvNumber());
			
			
			YearMonth ym=YearMonth.now();
			String date=ym.toString();
			System.out.println(date);
			preview.setCardAppliedDate(date);

			
			String valid=ym.plusYears(4).toString();
			System.out.println(valid);
			preview.setValidity(valid);
			
			
			request.setAttribute("values",PreviewDetails.display(preview));
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
