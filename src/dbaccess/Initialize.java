package dbaccess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.*;

import utilities.RentItem;
import controllers.CustomerMgmController;
import controllers.CustomerNotFoundException;
import controllers.GameDuplicateException;
import controllers.GameNotFoundException;
import controllers.GameMgmController;
import controllers.ItemDuplicateException;
import controllers.ItemNotFoundException;
import controllers.NotLegalStateException;
import controllers.OutOfStockException;
import controllers.RentMgmController;
import domain.Address;
import domain.Customer;
import domain.Game;
import domain.Item;
import domain.StateOfItem;
import dbaccess.JPAUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Initialize {

	
@SuppressWarnings("unused")
private void eraseData() {
	   	Session session = JPAUtil.getSessionFactory().getCurrentSession();
	   	session.beginTransaction();
	   	
        Query query = session.createQuery("DELETE FROM Item");
        query.executeUpdate();
        query = session.createQuery("DELETE FROM Game");
        query.executeUpdate();
        query = session.createQuery("DELETE FROM Customer");
        query.executeUpdate();
        query = session.createQuery("DELETE FROM Rent");
        query.executeUpdate();
        session.getTransaction().commit();
    }

	public void prepareData() throws NotLegalStateException, GameDuplicateException, GameNotFoundException, ItemNotFoundException, ItemDuplicateException, CustomerNotFoundException, OutOfStockException{
		try { 
			//eraseData();
			
			//Insert Customers
	
			CustomerMgmController mc = new CustomerMgmController();
			
			Customer customer1 = new Customer(new Address("Aristeidou", "11", "111", "Aigaleo", "Greece"),"Vithleem", "Govelou", "ioanpapada@gmail.com", "123","1","1","user");		
			mc.insertCustomer(customer1);
			Customer customer2 = new Customer(new Address("Aristeidou", "11", "111", "Aigaleo", "Greece"),"admin", "admin", "papaj@aueb.gr", "123", "2","2","admin");
			mc.insertCustomer(customer2);
			Customer customer3 = new Customer(new Address("Aristeidou", "11", "111", "Aigaleo", "Greece"),"pipirdos", "ppp", "papaj@aueb.gr", "123", "3","3","user");
			mc.insertCustomer(customer3);
		
			//Insert Games
			GameMgmController mg = new GameMgmController();
			
			Game game1 = new Game("GN0101","WARCRAFT","PC_GAME",1.20);
			mg.insertNewGame(game1);
			
			Game game2 = new Game("GN0102","STARCRAFT","PC_GAME",1.2);
			mg.insertNewGame(game2);
			
			Game game3 = new Game("GN0103","AOE","PC_GAME",1.25);
			mg.insertNewGame(game3);
			
			//Insert Items
			Item i1 = new Item("SN122349", StateOfItem.EXCELLENT, game1);
			mg.insertNewItem(i1);
			Item i2 = new Item("SN122350", StateOfItem.EXCELLENT, game1);
			mg.insertNewItem(i2);	
			Item i3 = new Item("SN122351", StateOfItem.EXCELLENT, game1);
			mg.insertNewItem(i3);		
			Item i4 = new Item("SN122352", StateOfItem.GOOD, game1);
			mg.insertNewItem(i4);
			Item i5 = new Item("SN122353", StateOfItem.GOOD, game2);
			mg.insertNewItem(i5);
			Item i6 = new Item("SN122354", StateOfItem.GOOD, game1);
			mg.insertNewItem(i6);
			Item i7 = new Item("SN122355", StateOfItem.BAD, game3);
			mg.insertNewItem(i7);
			Item i8 = new Item("SN122356", StateOfItem.GOOD, game2);
			mg.insertNewItem(i8);
			Item i9 = new Item("SN122357", StateOfItem.GOOD, game2);
			mg.insertNewItem(i9);
			Item i10 = new Item("SN122358", StateOfItem.BAD, game3);
			mg.insertNewItem(i10);
			
			//insert Rent
//			RentMgmController registerService1 = new RentMgmController();
//			Set<RentItem> rentItems1 = new HashSet<RentItem>();
//			rentItems1.add(new RentItem("WARCRAFT",1));
//			rentItems1.add(new RentItem("STARCRAFT",1));
//		
//			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date fm = null;
//			try {
//				fm = dateformat.parse("2014-12-12 10:10:10");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			System.out.println(registerService1.rent(customer1, rentItems1, fm ));
//			
//			RentMgmController registerService2 = new RentMgmController();
//			Set<RentItem> rentItems2 = new HashSet<RentItem>();
//			rentItems2.add(new RentItem("WARCRAFT",1));
//			System.out.println(registerService2.rent(customer2, rentItems2, fm));
//
//			RentMgmController registerService3 = new RentMgmController();
//			Set<RentItem> rentItems3 = new HashSet<RentItem>();
//			rentItems3.add(new RentItem("AOE",1));
//			System.out.println(registerService3.rent(customer1, rentItems3,  fm));
			
			System.out.println("\n\n Details Added \n"); 
		} 
		catch (HibernateException e) 
		{ 
			System.out.println(e.getMessage()); 
			System.out.println("error"); 
		}

	}
}
