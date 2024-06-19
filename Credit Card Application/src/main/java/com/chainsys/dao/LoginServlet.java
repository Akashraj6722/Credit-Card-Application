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
	static	Details details=new Details(); 
	static	BankDetails bankDetails = new BankDetails();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	


		try {
			request.setAttribute("info", AccountRecords.read(details, bankDetails));
			request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  
		

		String mail=request.getParameter("mail");
		String password=request.getParameter("pass");
		
		details.setMail(mail);
		details.setPassword(password);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("email", details.getMail());
		
		
		try {
			if(Records.check(details)==true) {
				
				
				if(details.getMail().endsWith("@admin.com")) {
					
					response.sendRedirect("AdminPage.jsp");
					
					
				}else {
				
				session.setAttribute("values", Records.read(details));
				request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);


				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	

	
	}


	}


