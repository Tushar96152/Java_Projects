import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
public class SendingEmail extends LogInPage {

    public SendingEmail(String sender,String reciever,String sub,String message){

        Properties prop = new Properties();
        prop.put("mail.smtp.auth",true);
        prop.put("mail.smtp.starttls.enable",true);
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.host","smtp.gmail.com");

        String username = "tushar96152@gmail.com";
        String password =  "cvnc pfqr zcpt cmpv";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        try{
            Message msg = new MimeMessage(session);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            msg.setFrom(new InternetAddress(sender));
            msg.setSubject(sub);
            msg.setText(message);
            Transport.send(msg);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
