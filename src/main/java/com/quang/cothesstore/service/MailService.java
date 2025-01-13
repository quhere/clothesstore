package com.quang.cothesstore.service;

import com.quang.cothesstore.model.Mail;
import org.springframework.stereotype.Service;

public interface MailService {
	public void sendEmail(Mail mail);
}
