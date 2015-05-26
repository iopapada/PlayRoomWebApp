package utilities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import domain.StateOfItem;

@XmlType(name="ItemAddInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemAddInfo {
	
	@XmlElement(required = true , nillable = false)
	private String gameCode;
	
	@XmlElement(required = true , nillable = false)
	private String serialNumOfItem;
	
	@XmlElement(required = true , nillable = false)
	private StateOfItem stateOfItem;

	public ItemAddInfo(){}
	
	public ItemAddInfo(String gameCode, String serialNumOfItem,
			StateOfItem stateOfItem) {
		super();
		this.gameCode = gameCode;
		this.serialNumOfItem = serialNumOfItem;
		this.stateOfItem = stateOfItem;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getSerialNumOfItem() {
		return serialNumOfItem;
	}

	public void setSerialNumOfItem(String serialNumOfItem) {
		this.serialNumOfItem = serialNumOfItem;
	}

	public StateOfItem getStateOfItem() {
		return stateOfItem;
	}

	public void setStateOfItem(StateOfItem stateOfItem) {
		this.stateOfItem = stateOfItem;
	}
}
