package com.snipe.CallHandling.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Common {
	
	public static Common common=new Common();
	
	public static  Common getInstance() {
		return common;
	}
	
	public static Map common()
	{
	//	ArrayList al=new ArrayList();
	//	HashMap  object=new HashMap();  
		/*object.put("status"," successful");
		//  object.put("topic","Registration");  
		  object.put("issuccess","true");
		  object.put("timestamp",System.currentTimeMillis() );
		  return object;  
		//return object;   
*/
		HashMap map=new HashMap();  
		ArrayList al=new ArrayList();  
		ArrayList dl=new ArrayList();   
		map.put("status", "true");

		 map.put("data",al);     
		
		map.put("error",dl);        
		return map;
	}
	
	
	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}  
	
	
	public static void email(String msg,String stremail ) 
	{
			
			String title="TICKETING SYSTEM";
			
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("kankurtemadhusudhan1993@gmail.com", "mohangmail93");// change  accordingly
																											
				}
			});

			// compose message
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("kankurtemadhusudhan1993@gmail.com"));// change
																							// accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(stremail));		
				message.setSubject(title);
				message.setText(msg);

				// send message
			Transport.send(message);

				System.out.println("message sent successfully");

			} 
			catch (MessagingException e) 
			{
				throw new RuntimeException(e);
			}
			
		}

	public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
