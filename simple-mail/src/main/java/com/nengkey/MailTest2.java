package com.nengkey;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailTest2 {

    static Authenticator auth = new Authenticator() {

        @Override

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("neckx@sohu.com", "220163");
        }
    };

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.sohu.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.from", "neckx@sohu.com");
        Session session = Session.getInstance(props, auth);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO, "heyg@wxgyxy.cn");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date());
            msg.setText("Hello, world! 发送邮件成功！\n");
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }

    }
}