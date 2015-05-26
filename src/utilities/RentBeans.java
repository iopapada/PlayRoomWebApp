package utilities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import controllers.RentMgmController;

public class RentBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<TempBean> listFournisseurs;
	private List<TempBean> tempListFournisseurs = new ArrayList<TempBean>();

	public RentBeans(){
		
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public List<TempBean> gettempListFournisseurs() throws ParseException {
	
	   RentMgmController r = new RentMgmController();
	   listFournisseurs = r.findAllOpenRents();
	   
	   
	   DateFormat  dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
	   Date d= null;
	   
	   Iterator iter = listFournisseurs.iterator();
	   while (iter.hasNext())
       {
           System.out.println("New object");
           Object[] obj = (Object[]) iter.next();
           for (int i=0;i<obj.length;i++)
           {
               //System.out.println(obj[i]);
           }
		   d= ((Date)obj[0]);
           TempBean tp = new TempBean(d,obj[1].toString(),obj[2].toString(),obj[3].toString(),obj[4].toString(),obj[5].toString(),obj[6].toString(),obj[7].toString());
           tempListFournisseurs.add(tp);     
       }
	   return tempListFournisseurs;
	
	}
	
	public void settempListFournisseurs(List<TempBean> listFournisseurs) {
	    this.tempListFournisseurs = listFournisseurs;
	}

	public void deltemplist() throws ParseException{
		gettempListFournisseurs().remove(0);
		
		//<h:commandButton value = "Return" action = "#{rentBeans.deltemplist() }" >
		//<f:setPropertyActionListener target="#{rentBeans.tempListFournisseurs}"  value="#{o}" />
		
	}
}
