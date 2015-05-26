package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;

/**
 * Servlet implementation class CustomerMgmControll
 */
@WebServlet("/CustomerMgmControll")
public class CustomerMgmControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerMgmControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CustomerMgmController cmc = new CustomerMgmController();
			Customer customer = Customer.newUserInstance(cmc.findCustomerById(Integer.parseInt(request.getParameter("id").toString())));
			customer.setId(Integer.parseInt(request.getParameter("id").toString()));
			customer.setUsername(request.getParameter("userfield").toString());
			customer.setPassword(request.getParameter("passfield").toString());
			customer.setTelephone(request.getParameter("telefield").toString());
			customer.setEmail(request.getParameter("mailfield").toString());
			cmc.updateCustomer(customer);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/customerPage.jsp");
			request.setAttribute("user", customer.getFirstName());
			request.setAttribute("username", customer.getUsername());
			request.setAttribute("password", customer.getPassword());
			request.setAttribute("telephone", customer.getTelephone());
			request.setAttribute("email", customer.getEmail());
			request.setAttribute("id", customer.getId());
			rd.forward(request, response);
		} catch (NumberFormatException | NotLegalStateException e) {
			e.printStackTrace();
		}		
	}

}
