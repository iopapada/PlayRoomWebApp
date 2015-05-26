package utilities;

import java.util.Date;

public class TempBean {

	public Date fromDate;
	public String title;
	public String serialNumOfItem;
	public String stateOfItem;
	public String firstName;
	public String lastName;
	public String customerCode;
	public String returnCode;
	

	public TempBean(Date fromDate, String title, String serialNumOfItem ,String stateOfItem
			, String firstName, String lastName, String customerCode,String returnCode) {

		this.setFromDate(fromDate);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSerialNumOfItem(serialNumOfItem);
		this.setStateOfItem(stateOfItem);
		this.setTitle(title);
		this.setReturnCode(returnCode);
		this.setCustomerCode(customerCode);
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSerialNumOfItem() {
		return serialNumOfItem;
	}

	public void setSerialNumOfItem(String serialNumOfItem) {
		this.serialNumOfItem = serialNumOfItem;
	}

	public String getStateOfItem() {
		return stateOfItem;
	}

	public void setStateOfItem(String stateOfItem) {
		this.stateOfItem = stateOfItem;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

}
