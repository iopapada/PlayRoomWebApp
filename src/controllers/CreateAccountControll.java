package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.SendCodeRegistrationService;
import dbaccess.JPAUtil;
import domain.Address;
import domain.Customer;

/**
 * Servlet implementation class CreateAccountControll
 */
@WebServlet("/CreateAccountControll")
public class CreateAccountControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateAccountControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Customer c = new Customer(new Address(request.getParameter("addrstreet"),request.getParameter("addrnumber"),request.getParameter("zipcode"),request.getParameter("city"),request.getParameter("country")),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),request.getParameter("telephone"),request.getParameter("username"),"user");
			CustomerMgmController cm = new CustomerMgmController();
			cm.insertCustomer(c);
			
			SendCodeRegistrationService notificationService = new SendCodeRegistrationService();
			notificationService.CodeAsDefaultPassword(c);
			
			response.sendRedirect("http://localhost:8080/PlayRoomWebApp2/faces/login.jsp");
			JPAUtil.getSessionFactory().getCurrentSession().close();
		} catch (NotLegalStateException e) {
			e.printStackTrace();
		}
	}

}
