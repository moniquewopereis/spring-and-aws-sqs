package br.com.mensageria.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController	
public class SmsService {
		
	@Value("${TWILIO_ACCOUNT_SID}")
	private String twilioAccountSid;
	
	@Value("${TWILIO_AUTH_TOKEN}")
	private String twilioAuthToken;
	
	@Value("${TWILIO_PHONE_FROM}")
	private String twilioPhoneFrom;
	
	@Value("${TWILIO_PHONE_TO}")
	private String twilioPhoneTo;
	
	@GetMapping(value = "/sendSMS")
	public ResponseEntity<String> sendSms() {
		Twilio.init(twilioAccountSid, twilioAuthToken);
		
		Message.creator(new PhoneNumber(twilioPhoneTo), new PhoneNumber(twilioPhoneFrom), "Monique, olá!").create();
		return new ResponseEntity<String> ("Message sent successfully", HttpStatus.OK);
	}

}
