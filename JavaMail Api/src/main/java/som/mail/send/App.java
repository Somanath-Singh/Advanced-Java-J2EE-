package som.mail.send;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App {

	public static void main(String[] args) {
		
		System.out.println("preparing to send message ...");
		String message = "Hello , Dear, this is message for security check . ";
		String subject = "CodersArea : Confirmation";
		String to = "singhsomanath247@gmail.com";
		String from = "somanathsingh531@gmail.com";

		sendEmail(message,subject,to,from);
	}

	//this is responsible to send email..
		private static void sendEmail(String message, String subject, String to, String from) {
			
			//Variable for gmail
			String host="smtp.gmail.com";
			
			//get the system properties
			Properties properties = System.getProperties();
			System.out.println("PROPERTIES "+properties);
			
			//setting important information to properties object
			
			//host set
//			properties.put("mail.smtp.host", host);
//			properties.put("mail.smtp.port","465");
//			properties.put("mail.smtp.ssl.enable","true");
//			properties.put("mail.smtp.auth","true");
			
			Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "465");
		      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		      
			
			//Step 1: to get the session object..
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {				
					return new PasswordAuthentication("somanathsingh531@gmail.com", "Singh@12345");
				}
				
				
				
			});
			
			session.setDebug(true);
			
			//Step 2 : compose the message [text,multi media]
			MimeMessage m = new MimeMessage(session);
			
			try {
			
			//from email
			m.setFrom();
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
		
			
			//adding text to message
			m.setText(message);
			
			//send 
			
			//Step 3 : send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent success...................");
			
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		
}
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SendHTMLEmail {
//
//public static void main(String[] args) {
//      // Recipient's email ID needs to be mentioned.
//      String to = "singhsomanath247@gmail.com";
//
//      // Sender's email ID needs to be mentioned
//      String from = "somanathsingh531@gmail.com";
//      final String username = "somanathsingh531@gmail.com";//change accordingly
//      final String password = "Singh@12345";//change accordingly
//
//      // Assuming you are sending email through relay.jangosmtp.net
//      String host = "smtp.gmail.com";
//
//      Properties props = new Properties();
//      props.put("mail.smtp.auth", "true");
//      props.put("mail.smtp.starttls.enable", "true");
//      props.put("mail.smtp.host", host);
//      props.put("mail.smtp.port", "465");
//
//      // Get the Session object.
//      Session session = Session.getInstance(props,
//         new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//               return new PasswordAuthentication(username, password);
//            }
//    });
//
//      try {
//            // Create a default MimeMessage object.
//            Message message = new MimeMessage(session);
//
//       // Set From: header field of the header.
//       message.setFrom(new InternetAddress(from));
//
//       // Set To: header field of the header.
//       message.setRecipients(Message.RecipientType.TO,
//              InternetAddress.parse(to));
//
//       // Set Subject: header field
//       message.setSubject("Testing Subject");
//
//       // Send the actual HTML message, as big as you like
//       message.setContent(
//              "<h1>This is actual message embedded in HTML tags</h1>",
//             "text/html");
//
//       // Send message
//       Transport.send(message);
//
//       System.out.println("Sent message successfully....");
//
//      } catch (MessagingException e) {
//       e.printStackTrace();
//       throw new RuntimeException(e);
//      }
//   }
//
//
//
//}