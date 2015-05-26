package utilities;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JMailEmailProvider implements EmailProvider{

    @Override
    public void sendEmail(String msgSubject, String msgBody, String recipientsEmails) throws Exception{
    	//Send mail
    	Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        //String msgBody = "...";
     	Transport transport = session.getTransport("smtps");
        try {   
        	transport.connect ("smtp.gmail.com",465, "ioanpapada@gmail.com", "io060496papada");        	
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("ioanpapada@gmail.com", "Papadakis Giannis"));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(recipientsEmails));
            msg.setSubject(msgSubject);//("Your Example.com account has been activated");
            msg.setText(msgBody);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (AddressException e) {
        	e.printStackTrace();
        } catch (MessagingException e) {
        	e.printStackTrace();
        }
    	//Send mail

    }

	
}
