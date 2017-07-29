package com.briup.action;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	private final static Logger LOGGER=LoggerFactory.getLogger(EmailController.class);
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping("/simple")
	public void sendSimpleMail()throws Exception{
		LOGGER.info("发送简单的文本邮件。。。。");
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("1320895332@qq.com");
		message.setTo("751471462@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容，这是我使用代码向你发的邮件，收到的话和我说一下");
		mailSender.send(message);
	}
	@RequestMapping("/attchmentts")
	public void sendAttachmentsMali()throws Exception{
		LOGGER.info("发送带附件的邮件。。。。");
		MimeMessage MimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(MimeMessage,true);
		helper.setFrom("1320895332@qq.com");
		helper.setTo("751471462@qq.com");
		helper.setSubject("主题：有附件的邮件");
		helper.setText("有附件的邮件");
		FileSystemResource resource = new FileSystemResource(new File("/static/img/logo.png"));
		helper.addAttachment("附件一.jpg", resource);
		helper.addAttachment("附件二.jpg", resource);
		mailSender.send(MimeMessage);
	}
	@RequestMapping("/inline")
	public void sendInlineMail()throws Exception{
		LOGGER.info("发送嵌入静态资源的邮件");
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
		mimeMessageHelper.setFrom("1320895332@qq.com");
		mimeMessageHelper.setTo("751471462@qq.com");
		mimeMessageHelper.setSubject("主题：嵌入静态资源");
		mimeMessageHelper.setText("<html><body><img src=\"cid:weixin\"></body></html>",true);
		FileSystemResource resource = new FileSystemResource(new File("weixin.jpg"));
		mimeMessageHelper.addInline("weixin", resource);
		mailSender.send(message);
	}
	@RequestMapping("/template")
	public void sendTemplateMail() throws Exception {
		LOGGER.info("发送简单邮件模板的邮件...");
	}
}
