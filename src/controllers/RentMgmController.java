package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dbaccess.JPAUtil;
import domain.Customer;
import domain.Game;
import domain.Item;
import domain.Rent;
import utilities.RentItem;
import utilities.TempBean;
public class RentMgmController {
	
	private static RentMgmController instance = null;
	
	public static RentMgmController getInstance(){
		if(instance == null){
			instance = new RentMgmController();
		}
		return (RentMgmController) instance;
	}
	
	@SuppressWarnings("rawtypes")
	public String rent(Customer customer, Set<RentItem> rentItems, Date fm) throws CustomerNotFoundException, NotLegalStateException, GameNotFoundException, OutOfStockException{
		Rent rent = new Rent();
		
		rent.setCustomer(customer);
		rent.setFromDate(fm);

		String msg = "";
		Iterator it = rentItems.iterator();
		while(it.hasNext()){
			RentItem rentItem = (RentItem) it.next();
			int willingQuantity = rentItem.getQuantity();
			Game game = GameMgmController.getInstance().findByTitle(rentItem.getGameTitle());
			
			List<Item> availableItems = GameMgmController.getInstance().findAvailableItems(game);
			if(availableItems.size() >= willingQuantity){
					for (int i=0; i < willingQuantity; i++){
						Item item = availableItems.get(i);
						item.setIsAvailable(false);
						GameMgmController.getInstance().update(item);
						rent.addItem(item);
					}
			}
		}	

		if (rent.getItems().size()!=0) {
			if(!RentMgmController.getInstance().save(rent)){
				throw new NotLegalStateException();
			}
			msg = "The rent is accompished";
		}
		else {
			msg = "The inventory is out of stock!";
			throw new OutOfStockException();
		}
		return msg;
	}
	public boolean save(Rent r){
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();	
        try{
	        em.save(r);
	        em.getTransaction().commit();   
	        return true;
	    } 
		catch (Exception ex) {
			em.beginTransaction().rollback();
	        return false;
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List<TempBean> findAllOpenRents(){
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null ;
		tx=em.beginTransaction(); 
		List<TempBean> l = new ArrayList<TempBean>();
		String jpql = "SELECT r.fromDate,ri.game.title,ri.serialNumOfItem,ri.stateOfItem,c.firstName,c.lastName,c.customerCode,r.returnCode FROM Rent r JOIN r.customer c JOIN r.items ri WHERE r.isOpened=1";
		Query query = em.createQuery(jpql);
        try{
        	
        	l=(List<TempBean>) query.list();
        	
            tx.commit() ; 
        }catch (Exception ex) {
			em.beginTransaction().rollback();
	    }
		return l;
	}
	
	@SuppressWarnings("rawtypes")
	public void returnRent(String returnCode, Date returnDate)
			throws //RentNotFoundException, RentIsReturnedException, 
			NotLegalStateException{

//		if(checkIfRentNotExists(returnCode)){
//			throw new RentNotFoundException(returnCode);
//		}
//		if(checkIfRentIsReturned(returnCode)){
//			throw new RentIsReturnedException(returnCode);
//		}
		Rent rent = RentMgmController.getInstance().findRentByReturnCode(returnCode);
		Set<Item> items = rent.getItems();
//		ReturnRent returnRent = new ReturnRent();
//		this.setInTimePaymentAndFine(rent, returnRent.getReturnDate());
//		Double totalPayment = extraPaymentFine + inTimePayment;

		//set rent not opened
		rent.setIsOpened(false);
		rent.setReturnDate(returnDate);
		RentMgmController.getInstance().updateRent(rent);

		//set rent items as available
		Iterator it = items.iterator();
		while(it.hasNext()){
			Item item = (Item) it.next();
			item.setIsAvailable(true);
			GameMgmController.getInstance().update(item);			
		}
	}
	
	public Rent findRentByReturnCode(String returnCode){
		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		tx = s.beginTransaction(); 
		String jpql = "SELECT r FROM Rent r WHERE r.returnCode = :returnCode";
		Query query = s.createQuery(jpql);
		query.setParameter("returnCode", returnCode); 
		Rent l = null;
		try{		
        	l=(Rent) query.uniqueResult();
            tx.commit() ; 
        }catch (Exception ex) {
			s.beginTransaction().rollback();
	    }
		return l;
	}
	
	public void updateRent(Rent rent) throws NotLegalStateException{

		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
        try{
        	tx = s.beginTransaction(); 
        	s.update(rent);
        	tx.commit();        	
        } 
        catch (Exception ex) {
        	tx.rollback();
        }
	}
}
