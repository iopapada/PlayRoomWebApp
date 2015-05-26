package utilities;

public interface EmailProvider {
   
	void sendEmail(String msgSubject, String msgBody, String recipientsEmails) throws Exception;
}
