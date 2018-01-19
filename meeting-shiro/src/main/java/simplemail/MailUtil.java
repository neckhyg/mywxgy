package simplemail;

//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import javax.mail.MessagingException;

//import com.shadow.mvc.vo.Mail;

/**
 * 邮件发送工具实现类
 * 
 * @author shadow
 * @create 2013/07/12
 */
public class MailUtil {

	protected final Logger logger = Logger.getLogger(getClass());

	public boolean send(Mail mail) {
//		// 发送email
//		HtmlEmail email = new HtmlEmail();
//		try {
//			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
//			email.setHostName(mail.getHost());
//			// 字符编码集的设置
//			email.setCharset(Mail.ENCODEING);
//			// 收件人的邮箱
//			email.addTo(mail.getReceiver());
//			// 发送人的邮箱
//			email.setFrom(mail.getSender(), mail.getName());
//			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
//			email.setAuthentication(mail.getUsername(), mail.getPassword());
//			// 要发送的邮件主题
//			email.setSubject(mail.getSubject());
//			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
//			email.setMsg(mail.getMessage());
//			// 发送
//			email.send();
//			if (logger.isDebugEnabled()) {
//				logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver());
//			}
//			return true;
//		} catch (EmailException e) {
//			e.printStackTrace();
//			logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver()
//					+ " 失败");
//			return false;
//		}
        return false;
	}
	 public static void main(String[] args) throws MessagingException {
	    	Mail mail = new Mail();

	    	mail.setHost("smtp.wxgyxy.cn");
	    	mail.setSender("heyg@wxgyxy.cn");
	    	mail.setUsername("heyg@wxgyxy.cn");
	    	mail.setPassword("wxgy2013");

	    	mail.setReceiver("neckx@sohu.com");

	    	mail.setSubject("测试邮件");
	    	mail.setMessage("测试的HTML邮件");
	    	MailUtil util = new MailUtil();
	    	util.send(mail);
	 }
}
