package com.chainsys.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.chainsys.model.EmploymentDetails;
import com.chainsys.model.PreviewDetails;
import com.chainsys.model.Details;
import com.chainsys.model.BankDetails;
import com.chainsys.model.CreditCardDetails;
import com.chainsys.util.AccountRecords;
import com.chainsys.util.CardRecords;
import com.chainsys.util.EmploymentRecords;
import com.chainsys.util.Records;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
@MultipartConfig

public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static	Details details = new Details();
	static	EmploymentDetails employment = new EmploymentDetails();
	static	CreditCardDetails card = new CreditCardDetails();
	static	BankDetails bankDetails = new BankDetails();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CardServlet() {
		super();
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sess = request.getSession();

		ArrayList<Details> values1 = (ArrayList<Details>) sess.getAttribute("values");
		for (Details display : values1) {

			String fName = display.getfName();
			String lName = display.getlName();

			details.setMail(display.getMail());
			details.setPassword(display.getPassword());

			

			card.setHolderName(fName + " " + lName);

			employment.setOccupation(request.getParameter("occupation"));

			employment.setCompanyname(request.getParameter("companyName"));
			employment.setDesignation(request.getParameter("designation"));

			Long income = Long.parseLong(request.getParameter("annualIncome"));
			employment.setIncome(income);
			
			InputStream inputStream=null;
			Part incomePart=request.getPart("incomeProof");
			inputStream=incomePart.getInputStream();
			employment.setIncomeProof(inputStream.readAllBytes());
			
			

			try {
				Records.readSpecific(details);// to get customer id
				
				AccountRecords.read(details, bankDetails); // to get account number
				EmploymentRecords.insert(employment, details);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			if (income >= 200000 && income < 400000) {
				//silver

				card.setCardNumber(NumberGeneration.rupayCreditCardNumber());
				card.setCvvNumber(NumberGeneration.ccvNumber());

				YearMonth ym = YearMonth.now();
				String date = ym.toString();
				card.setCardAppliedDate(date);

				String valid = ym.plusYears(3).toString();
				card.setValidity(valid);
				card.setCardType("silver");

				try {
					CardRecords.insert(card, display, bankDetails);
					request.setAttribute("values", PreviewDetails.display(card));
					request.getRequestDispatcher("PreviewSilver.jsp").forward(request, response);


				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				
			} else if (income >= 400000 && income < 600000) {
				//gold card
				card.setCardNumber(NumberGeneration.pulseCreditCardNumber());
				card.setCvvNumber(NumberGeneration.ccvNumber());

				YearMonth ym = YearMonth.now();
				String date = ym.toString();
				card.setCardAppliedDate(date);

				String valid = ym.plusYears(3).toString();
				card.setValidity(valid);
				card.setCardType("gold");

				try {
					CardRecords.insert(card, display, bankDetails);
					request.setAttribute("values", PreviewDetails.display(card));
					request.getRequestDispatcher("PreviewGold.jsp").forward(request, response);

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				
			} else if (income >= 600000 && income < 800000) {
				//platinum card

				card.setCardNumber(NumberGeneration.visaCreditCardNumber());
				card.setCvvNumber(NumberGeneration.ccvNumber());

				YearMonth ym = YearMonth.now();
				String date = ym.toString();
				card.setCardAppliedDate(date);

				String valid = ym.plusYears(4).toString();
				card.setValidity(valid);
				card.setCardType("platinum");

				try {
					CardRecords.insert(card, display, bankDetails);
					request.setAttribute("values", PreviewDetails.display(card));
					request.getRequestDispatcher("PreviewPlatinum.jsp").forward(request, response);


				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				
			} else if (income > 800000) {
				//elite
				card.setCardNumber(NumberGeneration.masterCreditCardNumber());
				card.setCvvNumber(NumberGeneration.ccvNumber());

				YearMonth ym = YearMonth.now();
				String date = ym.toString();
				card.setCardAppliedDate(date);

				String valid = ym.plusYears(5).toString();
				card.setValidity(valid);
				card.setCardType("elite");

				try {
					CardRecords.insert(card, display, bankDetails);
					request.setAttribute("values", PreviewDetails.display(card));
					request.getRequestDispatcher("PreviewElite.jsp").forward(request, response);


				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				
			} else {
                //sorry U are not eligible

			}

		}

	}
}
