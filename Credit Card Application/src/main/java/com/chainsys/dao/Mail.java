package com.chainsys.dao;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

public class Mail {

    static Session newSession = null;

    public static void main(String[] args) {
        try {
            setProperties();
            setMailBody(null, null);
            System.out.println("Email sent successfully.");
        } catch (Exception ex) {
            System.out.println("Failed to send email.");
            ex.printStackTrace();
        }
    }

    public static void setProperties() {
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        newSession = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iamakash6722@gmail.com", "ztdb otld cwza bvyy");
            }
        });
    }

    public static void setMailBody(String emailRecipient, String emailBody) throws AddressException, MessagingException {
//        String emailRecipients =  "akashroman36@gmail.com" ;
        String emailSubject = "Credit Card Approval";
//        String emailBody = "Your  card has been Approved";

        Message mimeMessage = new MimeMessage(newSession);
        mimeMessage.setFrom(new InternetAddress("your-email@example.com"));

//        for (String recipient : emailRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipient));
//        }

        mimeMessage.setSubject(emailSubject);
        mimeMessage.setText(emailBody);

        Transport.send(mimeMessage);
    }
}
