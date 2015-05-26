package domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="games")
public class Game {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="title", length=200, nullable=false, unique=true)
	@NotEmpty
	private String title;

	@Column(name="codeOfGame", length=20, nullable=false, unique=true)
	@NotEmpty
	@Pattern(regexp="GN\\d{1,}",message="{invalid.serialNumOfItem}")
	private String codeOfGame;
	
	@Column(name="descriptionOfGame", length=200, nullable=true)
	private String descriptionOfGame;
	
	@Column(name="chargePerDay", nullable=true)
	@Min(0)
	private double chargePerDay;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insertDate",nullable=false)
	private Date insertDate;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, mappedBy="game", fetch=FetchType.EAGER)
	private Set<Item> items = new HashSet<Item>();

	public Set<Item> getItems() {
		return new HashSet<Item>(this.items);
	}
	
	Set<Item> friendItems(){
		return this.items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item){
		if(item != null){ item.setGame(this); }
	}
	
	public void removeItem(Item item){
		if(item != null){ item.setGame(null); }
	}
	
	public Game(){}
	
	public Game(String code, String title, String description, double chargePerDay){
		
		this.setCodeOfGame(code);
		this.setTitle(title);
		this.setDescriptionOfGame(description);
		this.setChargePerDay(chargePerDay);
		this.setInsertDate(new Date());
		
	}
	
//	public Game (GameAddInfo gameAddInfo){
//		this.setCodeOfGame(gameAddInfo.getCode());
//		this.setTitle(gameAddInfo.getTitle());
//		this.setDescriptionOfGame(gameAddInfo.getDescription());
//		this.setChargePerDay(gameAddInfo.getChargePerDay());
//		this.setChargeFinePerDay(gameAddInfo.getChargeFinePerDay());
//		this.setLowLevelItemsOfGame(gameAddInfo.getLowLevelItemsOfGame());
//		this.setMaxPeriodRentOfGame(gameAddInfo.getMaxPeriodRentOfGame());
//		Date date = new Date();
//		this.setInsertDate(date);
//	}

	public long getId() {
		return id;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCodeOfGame() {
		return codeOfGame;
	}
	public void setCodeOfGame(String codeOfGame) {
		this.codeOfGame = codeOfGame;
	}
	public String getDescriptionOfGame() {
		return descriptionOfGame;
	}
	public void setDescriptionOfGame(String descriptionOfGame) {
		this.descriptionOfGame = descriptionOfGame;
	}
	public double getChargePerDay() {
		return chargePerDay;
	}
	public void setChargePerDay(double chargePerDay) {
		this.chargePerDay = chargePerDay;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}