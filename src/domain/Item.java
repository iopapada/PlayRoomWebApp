/**
 * 
 */
package domain;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import utilities.ItemAddInfo;
@Entity
@Table(name="items")
public class Item {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="serialNumOfItem",length=30, nullable=false)
	@NotEmpty
	@Pattern(regexp="SN\\d{1,}",message="{invalid.serialNumOfItem}")
	private String serialNumOfItem;
	
	public String getSerialNumOfItem() {
		return serialNumOfItem;
	}

	public void setSerialNumOfItem(String serialNumOfItem) {
		this.serialNumOfItem = serialNumOfItem;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="stateOfItem", nullable=false)
	private StateOfItem stateOfItem;

	public StateOfItem getStateOfItem() {
		return stateOfItem;
	}

	public void setStateOfItem(StateOfItem stateOfItem) {
		this.stateOfItem = stateOfItem;
	}
	
	@Column(name="isAvailable")
	private Boolean isAvailable=true;

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="gameno", nullable=false)
	private Game game;
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		if(this.game != null){
			this.game.friendItems().remove(this);
		}
		this.game = game;
		if(this.game != null){
			this.game.friendItems().add(this);
		}
	}

	public Item(){}
	
	public Item(String serialNumOfItem, StateOfItem stateOfItem, Game game){
		this.setIsAvailable(true);
		this.setSerialNumOfItem(serialNumOfItem);
		this.setStateOfItem(stateOfItem);
		this.setGame(game);
	}

	public Item(ItemAddInfo itemAddInfo, Game game){
		this.setSerialNumOfItem(itemAddInfo.getSerialNumOfItem());
		this.setIsAvailable(true);
		this.setStateOfItem(itemAddInfo.getStateOfItem());
		this.setGame(game);
	}
	
}