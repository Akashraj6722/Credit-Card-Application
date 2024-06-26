package com.chainsys.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.chainsys.model.BankDetails;
import com.chainsys.model.Details;
import com.chainsys.util.AccountRecords;
import com.chainsys.util.Records;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
@MultipartConfig
		
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Details details = new Details();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
	public BankServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("values", Records.read(details));
			request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		BankDetails bankDetails = new BankDetails();

		details.setfName(request.getParameter("fName"));
		details.setlName(request.getParameter("lName"));
		details.setDob(request.getParameter("DOB"));
		details.setAadhaar(request.getParameter("aadhaar"));
		details.setPan(request.getParameter("pan"));
		details.setMail(request.getParameter("mail"));
		details.setPhone(request.getParameter("ph"));
		details.setPassword(request.getParameter("pass"));

		

		try {InputStream inputStream = null;
		Part aadhaarPart = request.getPart("aadhaarProof");
		inputStream = aadhaarPart.getInputStream();
		details.setAadhaarProof(inputStream.readAllBytes());

		Part panPart = request.getPart("panProof");
		inputStream = panPart.getInputStream();
		details.setPanProof(inputStream.readAllBytes());

		bankDetails.setAccountNumber(NumberGeneration.accountNumber());
		bankDetails.setIfsc(NumberGeneration.ifsc());
		
		
			Records.insert(details);
			Records.read(details);
			AccountRecords.insert(details, bankDetails);
			response.sendRedirect("MainPage.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		


		

	}
}
