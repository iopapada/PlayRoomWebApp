package utilities;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import controllers.NotLegalStateException;
import controllers.RentMgmController;

@ManagedBean
@RequestScoped
public class ReturnBeans {
	
	private String returnCode;
	
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	private Date returnDate;
	
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public ReturnBeans(){}
	
	public void returnRent() throws NotLegalStateException, IOException{
		
		this.returnDate = new Date();
		
		RentMgmController.getInstance().returnRent(this.returnCode,this.returnDate);
		FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/PlayRoomWebApp2/faces/adminPage.jsp");

	}


}
