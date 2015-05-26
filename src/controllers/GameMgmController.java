package controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dbaccess.JPAUtil;
import domain.Game;
import domain.Item;

public class GameMgmController {
	
	
	private static GameMgmController instance = null;
	
	public static GameMgmController getInstance(){
		if(instance == null){
			instance = new GameMgmController();
		}
		return (GameMgmController) instance;
	}
	
	public boolean insertNewGame(Game game){
		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
        try{
        	tx = s.beginTransaction(); 
        	s.save(game);
        	tx.commit();
        } 
        catch (Exception ex) {
        	s.beginTransaction().rollback();
        	return false;
        }	
		return true;
	}
	
	public Game findGameByCode(String gameCode) throws GameNotFoundException {
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();	
		String jpql = "SELECT g FROM Game g WHERE g.codeOfGame = :gameCode";
		Query query = em.createQuery(jpql);
		query.setParameter("gameCode", gameCode);  
		Game game = null;    
        try {
            if(query != null) 
            	game  = (Game) query.uniqueResult();
            em.getTransaction().commit();        	
        } catch (Exception ex) {
        	em.beginTransaction().rollback();
        }
		
		if(game == null){
			throw new GameNotFoundException(gameCode);
		}
		return game;
	}
	
	public boolean insertNewItem(Item item) throws ItemDuplicateException, GameNotFoundException, NotLegalStateException{
		
		Session s = JPAUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
        try{
        	tx = s.beginTransaction();
        	s.save(item);
        	tx.commit();
        } 
        catch (Exception ex) {
        	tx.rollback();
        	return false;
        }	
		
		return true;
	}
	
	public Item findBySerialNumber(String itemCode) throws ItemNotFoundException {		
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();	
		String jpql = "SELECT i FROM Item i WHERE i.serialNumOfItem = :itemCode";
		Query query = em.createQuery(jpql);
		query.setParameter("itemCode", itemCode);   
		Item item = null;    
        try {
            if(query != null) 
            	item  = (Item) query.uniqueResult();
            em.getTransaction().commit();
        } catch (Exception ex) {
        	em.beginTransaction().rollback();
        }
		
		if(item == null){
			throw new ItemNotFoundException(itemCode);
		}
		return item;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Item> findAvailableItems(Game game) {
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();
		String jpql = "SELECT i FROM Item i JOIN i.game g WHERE i.isAvailable = true and g.codeOfGame = :codeOfGame";
		Query query = em.createQuery(jpql);
		query.setParameter("codeOfGame", game.getCodeOfGame());  
		
		List<Item> items = null;
		try {
            if(query != null) 
            	items = (List<Item>) query.list();
            em.getTransaction().commit();
        } catch (Exception ex) {
        	em.beginTransaction().rollback();
        }
		
		return items;
	}
	
	public Game findByTitle(String title) {
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();
		String jpql = "SELECT g FROM Game g WHERE g.title = :title";
		Query query = em.createQuery(jpql);
		query.setParameter("title", title);  
		
		Game game = null;    
        try {
            if(query != null) 
            	game  = (Game) query.uniqueResult();
            em.getTransaction().commit();        	
        } catch (Exception ex) {
        	em.beginTransaction().rollback();
        }

		return game;
	}
	
	public boolean update(Item item){
		Session em = JPAUtil.getSessionFactory().getCurrentSession();
		em.beginTransaction();
        try{
	        em.merge(item);
	        em.getTransaction().commit(); 
	        return true;
	    } 
		catch (Exception ex) {
			em.beginTransaction().rollback();
        	return false;
	    }
	}
}
