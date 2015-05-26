package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import utilities.RentItem;

/**
 * Servlet implementation class CreateRentControll
 */
@WebServlet("/CreateRentControll")
public class CreateRentControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRentControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] gameTitle = (request.getParameter("RentGame").toString()).split("-");
		int quantity = Integer.parseInt(request.getParameter("itemsfield").toString());

		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datefrom = null;
		Customer c = null;
		try {
			datefrom = dateformat.parse(request.getParameter("datefield").toString());
			int customerID = Integer.parseInt(request.getSession().getAttribute("id").toString());
			c = CustomerMgmController.getInstance().findCustomerById(customerID);
			
		} catch (ParseException | NotLegalStateException e) {
			e.printStackTrace();
		}
		
		RentMgmController insertRent = new RentMgmController();
		Set<RentItem> rentItems = new HashSet<RentItem>();
		rentItems.add(new RentItem(gameTitle[1],quantity));
		try {
			insertRent.rent(c, rentItems, datefrom );
		} catch (CustomerNotFoundException | NotLegalStateException | GameNotFoundException | OutOfStockException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/customerPage.jsp");
		request.setAttribute("user", c.getFirstName());
		request.setAttribute("username", c.getUsername());
		request.setAttribute("password", c.getPassword());
		request.setAttribute("telephone", c.getTelephone());
		request.setAttribute("email", c.getEmail());
		request.setAttribute("id", c.getId());
		rd.forward(request, response);
	}
}
