package controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dbaccess.JPAUtil;
import domain.Customer;

public class CustomerMgmController {

	private static CustomerMgmController instance = null;
	public static CustomerMgmController getInstance(){
		if(instance == null){
			instance = new CustomerMgmController();
		}
		return (CustomerMgmController) instance;
	}
	
	private static Transaction tx;
	public String insertCustomer(Customer customer) throws NotLegalStateException{

		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
        try{
        	tx = s.beginTransaction(); 
        	s.save(customer);
        	tx.commit();        	
        } 
        catch (Exception ex) {
        	tx.rollback();
        }
		return customer.getCustomerCode();
	}
	
	public void updateCustomer(Customer customer) throws NotLegalStateException{

		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
        try{
        	tx = s.beginTransaction(); 
        	s.update(customer);
        	tx.commit();        	
        } 
        catch (Exception ex) {
        	tx.rollback();
        }
	}
	
	public Customer findCustomerById(int id) throws NotLegalStateException{

		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		String jpql = "SELECT c FROM Customer c WHERE c.id = :i";
		Query query = s.createQuery(jpql);
		query.setParameter("i", id);
		Customer a = null;
        try{
        	
        	if(query != null) 
            	a  = (Customer) query.uniqueResult(); 
        	tx.commit();        	
        } 
        catch (Exception ex) {
        	tx.rollback();
        }
        return a;
	}
	
	public Customer authentCustomer(String user,String pass) {
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		if(em.getTransaction().isActive()){
			tx = em.getTransaction();
		}
		else {
			tx = em.beginTransaction();
		}
		String jpql = "SELECT c FROM Customer c WHERE c.username = :u and c.password = :p";
		Query query = em.createQuery(jpql);
		query.setParameter("u", user).setParameter("p", pass);

        Customer a = null;    
        try {
            if(query != null) 
            	a  = (Customer) query.uniqueResult(); 
            tx.commit();   	
        } catch (Exception ex) {
        	tx.rollback();
        }
        return a;
	}

}
