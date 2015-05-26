package utilities;

import domain.Customer;



public class SendCodeRegistrationService{
    private EmailProvider provider = new JMailEmailProvider();
    
    public void CodeAsDefaultPassword(Customer c) {
    	try {
    	String msgBody = "";
    	String msgSubject = "Credentials for your New Account in PLAYROOM";
		msgBody = ""
				+ "Welcome " + c.getFirstName().toString()+ c.getLastName().toString() +"\n"
				+ "Username:"+ c.getUsername().toString()+ "\n"
				+ "Password:"+ c.getPassword().toString()+ "\n";
	
			provider.sendEmail(msgSubject, msgBody, c.getEmail().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }

}
