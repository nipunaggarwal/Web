package nipun.org.web2;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {

	public static void main(String[] args) {

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			//System.out.println("in the try block");
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("nipunaggarwal16@gmail.com",
					"Admin"));
			//System.out.println("Admin");
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"nipun.aggarwal@brightlifecare.com", "Mr. User"));
			//System.out.println("User");
			msg.setSubject("Your Example.com account has been activated");
			//System.out.println("subject");
			Transport.send(msg);
			System.out.println("sent");
			System.out.println("Your msg has been sent");
		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}

}
