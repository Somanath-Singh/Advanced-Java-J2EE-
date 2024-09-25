//package utilities;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//public class Mail {
//	
//	//SETUP MAIL SERVER PROPERTIES
//	//DRAFT AN EMAIL
//	//SEND EMAIL
//	
//    Session newSession = null;
//    MimeMessage mimeMessage = null;
//	public static void main(String[] args) throws AddressException, MessagingException
//	{
//		Mail mail = new Mail();
//		mail.setupServerProperties();
//		mail.draftEmail();
//		mail.sendEmail();
//	}
//
//	private void sendEmail() throws MessagingException {
//		String fromUser = "jenapriyadarshini0602@gmail.com";
//		String fromUserPassword = "cjnz fuwo jlhy dxgk";
//		String emailHost = "smtp.gmail.com";
//		Transport transport = newSession.getTransport("smtp");
//		transport.connect(emailHost, fromUser, fromUserPassword);
//		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
//		transport.close();
//		System.out.println("Email successfully sent!!!");
//		
//		
//	}
//
//	private MimeMessage draftEmail() throws AddressException, MessagingException {
//		String[] emailReceipients = {"somanathsingh531@gmail.com"};
//		String emailSubject = "Test Mail";
//		String emailBody = "Hii ...This is Barsa from this side";
//		mimeMessage = new MimeMessage(newSession);
//		
//		for(int i=0; i<emailReceipients.length;i++) {
//			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
//		}
//		mimeMessage.setSubject(emailSubject);
//		
//		MimeBodyPart bodyPart = new MimeBodyPart();
//		bodyPart.setContent(emailBody, "text/html");
//		MimeMultipart multiPart = new MimeMultipart();
//		multiPart.addBodyPart(bodyPart);
//		mimeMessage.setContent(multiPart);
//		return mimeMessage;
//		
//	}
//
//	private void setupServerProperties() {
//		Properties properties = System.getProperties();
//		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		newSession = Session.getDefaultInstance(properties, null);
//		
//	}
//}

package utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.clgw.javabeans.MailJavaBeans;

public class Mail {
	
	//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
	
    Session newSession = null;
    MimeMessage mimeMessage = null;
	public static void main(String[] args) throws AddressException, MessagingException
	{
		Mail mail = new Mail();
		mail.setupServerProperties();
		mail.draftEmail();
		mail.sendEmail();
	}

	private void sendEmail() throws MessagingException {
		String fromUser = "jenapriyadarshini0602@gmail.com";
		String fromUserPassword = "cjnz fuwo jlhy dxgk";
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
		
		
	}

	private MimeMessage draftEmail() throws AddressException, MessagingException {
		
		//create the object of java beans class
		MailJavaBeans m=new MailJavaBeans();
		//pass the value through getter and setter method
		m.setToUser("somanathsingh531@gmail.com");
		m.setMsg("Hii ...This is Somanath from this side");
		
		String[] emailReceipients = {m.getToUser()};
		String emailSubject = "Test Mail";
		String emailBody = m.getMsg();
		mimeMessage = new MimeMessage(newSession);
		
		for(int i=0; i<emailReceipients.length;i++) {
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
		}
		mimeMessage.setSubject(emailSubject);
		
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(emailBody, "text/html");
		MimeMultipart multiPart = new MimeMultipart();
		multiPart.addBodyPart(bodyPart);
		mimeMessage.setContent(multiPart);
		return mimeMessage;
		
	}

	private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties, null);
		
	}
}

