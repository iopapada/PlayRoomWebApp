package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbaccess.Initialize;
import domain.Customer;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class LoginControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null)
		    session.invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Initialize i = new Initialize();
//		try {
//			i.prepareData();
//		} catch (NotLegalStateException | GameDuplicateException | GameNotFoundException | ItemNotFoundException | ItemDuplicateException | CustomerNotFoundException | OutOfStockException e) {
//			e.printStackTrace();
//		}
		
		RequestDispatcher rd = null;
 
		if (request.getParameter("SignUp") != null) {
			rd = request.getRequestDispatcher("/signUpPage.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("SignIn") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			CustomerMgmController authenticator = new CustomerMgmController();
			Customer result = authenticator.authentCustomer(username, password);
			if (result != null) {
				if(result.getUserrights().equals("admin")) {
					rd = request.getRequestDispatcher("/adminPage.jsp");
			    	request.setAttribute("user", result.getUsername());
				}
				else
					rd = request.getRequestDispatcher("/customerPage.jsp");
				 	HttpSession session=request.getSession();  
			        session.setAttribute("username",result.getUsername()); 
			        session.setAttribute("userCode",result.getCustomerCode());
			        session.setAttribute("id",result.getId());
			        
					request.setAttribute("user", result.getFirstName());
					request.setAttribute("username", result.getUsername());
					request.setAttribute("password", result.getPassword());
					request.setAttribute("telephone", result.getTelephone());
					request.setAttribute("email", result.getEmail());
					request.setAttribute("id", result.getId());
			} else {
			    rd = request.getRequestDispatcher("/loginFailed.jsp");
			}
			rd.forward(request, response);
		}
	}

}
