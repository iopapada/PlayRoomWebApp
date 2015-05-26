/**
 * 
 */
package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang.RandomStringUtils;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
// 
//@ManagedBean(name="order")
//@SessionScoped
@Entity
@Table(name="rents")
public class Rent {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	//@org.hibernate.annotations.Type(
            //type="persistence.SimpleCalendarCustomType")
    @Column(name="fromDate",nullable=false)
	private Date fromDate;

	@Column(name="isOpened",nullable=false)
	private Boolean isOpened;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)//to Lazy anti gia EAGER den mou eferne ta items
	@JoinTable(name="rentitems", 
				joinColumns={@JoinColumn(name="rentid", nullable=false)}, 
				inverseJoinColumns={@JoinColumn(name="itemid", nullable=false)})
	private Set<Item> items = new HashSet<Item>();
	
	public Set<Item> getItems() {
		return new HashSet<>(this.items);
	}
	
    public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		if(item != null) { 
			this.items.add(item);
		}
	}

	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="customerno", nullable=false)
	private Customer customer;
    
    @Column(name="returnCode", unique=true)
    private String returnCode;
		
	@Column(name="returnDate",nullable=true)
	private Date returnDate;
	
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
    public Rent(){
    	this.isOpened = true;
    	//this.fromDate = SystemDate.now();
    	this.items = new HashSet<Item>();
    	this.returnCode = this.returnCodeGenerator();
    }
	
	public Rent(Customer c, Set<Item> items){
		this.returnCode = this.returnCodeGenerator();
		this.setCustomer(c);
		this.fromDate = new Date();
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item item = (Item) it.next();
			this.getItems().add(item);
			if(item != null) item.setIsAvailable(false);
		}
		this.isOpened = true;
	}
	
	//Copy constructor
	public static Rent newInstance(Rent rent) {
	    return new Rent(rent.getCustomer(), rent.getItems());
	}



	public Customer getCustomer() {
    	return customer;
    	//return Customer.newInstance(this.customer);
	}
    
	public Long  getId() {
		return id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fm) {
		this.fromDate = fm;
	}

	public Boolean getIsOpened() {
		return isOpened;
	}

	public void setIsOpened(Boolean isOpened) {
		this.isOpened = isOpened;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void removeItem(Item item){
		if(item != null) { 
			this.items.remove(item); 
		}
	}

	public String getReturnCode() {
		return returnCode;
	}
    
    public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
    
	private String returnCodeGenerator() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

}
