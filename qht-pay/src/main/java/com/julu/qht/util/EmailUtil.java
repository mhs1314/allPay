package com.julu.qht.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/*
 * 邮件工具类
 */
@Service
public class EmailUtil {
    /*@Value("${spring.mail.host}")
    private  String host;
    @Value("${spring.mail.username}")
    private  String username;
    @Value("${spring.mail.port}")
    private  String port;
    @Value("${spring.mail.protocol}")
    private static String protocol;
    @Value("${spring.mail.password}")
    private  String password;

    public void send_mail(String email, String code) throws MessagingException {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        System.out.println("host:"+host);
        System.out.println("port:"+port);
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        //设置发送邮件的基本参数
        //发送邮件服务器
        //"smtp.huic188.com"
        properties.put("mail.smtp.host",host);
        //发送端口
        //"25"
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码 "services@uustream.com","WSJS840226wsjs"
                return new PasswordAuthentication(username,password);
            }
        });

        //String text = "【孙嘉】  您的验证码为"+code+"该验证码1分钟内有效，请勿泄露于他人！";
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人"services@uustream.com")
        message.setFrom(new InternetAddress(username));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
        //设置主题
        message.setSubject("微链云多商户验证码");
        //设置邮件正文  第二个参数是邮件发送的类型
        String text = "您的验证码为"+code+"，该验证码10分钟内有效，请勿泄露于他人！";
        message.setContent(text, "text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);
    }
    
    public  boolean testMacSend_Email(String email, String url) throws MessagingException {
    		//创建连接对象 连接到邮件服务器
            Properties properties = new Properties();
            System.out.println("host:"+host);
            System.out.println("port:"+port);
            System.out.println("username:"+username);
            System.out.println("password:"+password);
            //设置发送邮件的基本参数
            //发送邮件服务器
            //"smtp.huic188.com"
            properties.put("mail.smtp.host",host);
            //发送端口
            //"25"
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            //设置发送邮件的账号和密码
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //两个参数分别是发送邮件的账户和密码 "services@uustream.com","WSJS840226wsjs"
                    return new PasswordAuthentication(username,password);
                }
            });

            //String text = "【孙嘉】  您的验证码为"+code+"该验证码1分钟内有效，请勿泄露于他人！";
            //创建邮件对象
            Message message = new MimeMessage(session);
            //设置发件人"services@uustream.com")
            message.setFrom(new InternetAddress(username));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            //设置主题
            message.setSubject("微链云多商户监测机配置信息");
            //设置邮件正文  第二个参数是邮件发送的类型
            String text = "请点击链接查看监测机配置信息,并及时回复配置后的taskID "+url;
            message.setContent(text, "text/html;charset=UTF-8");
            //发送一封邮件
            Transport.send(message);
            return true;
    }
    
    
    public  boolean testMacDataSend_Email(String email, String url) throws AddressException, MessagingException{
    		//创建连接对象 连接到邮件服务器
            Properties properties = new Properties();
            System.out.println("host:"+host);
            System.out.println("port:"+port);
            System.out.println("username:"+username);
            System.out.println("password:"+password);
            //设置发送邮件的基本参数
            //发送邮件服务器
            //"smtp.huic188.com"
            properties.put("mail.smtp.host",host);
            //发送端口
            //"25"
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            //设置发送邮件的账号和密码
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //两个参数分别是发送邮件的账户和密码 "services@uustream.com","WSJS840226wsjs"
                    return new PasswordAuthentication(username,password);
                }
            });

            //String text = "【孙嘉】  您的验证码为"+code+"该验证码1分钟内有效，请勿泄露于他人！";
            //创建邮件对象
            Message message = new MimeMessage(session);
            //设置发件人"services@uustream.com")
            message.setFrom(new InternetAddress(username));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            //设置主题
            message.setSubject("微链云多商户监测机监测数据");
            //设置邮件正文  第二个参数是邮件发送的类型
            String text = "请点击链接查看监测机监测数据 "+url;
            message.setContent(text, "text/html;charset=UTF-8");
            //发送一封邮件
            Transport.send(message);
            return true;
    }*/
}
