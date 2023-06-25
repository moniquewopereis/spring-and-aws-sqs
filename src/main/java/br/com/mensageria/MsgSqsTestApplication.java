package br.com.mensageria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.awspring.cloud.sqs.annotation.SqsListener;

@SpringBootApplication
public class MsgSqsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgSqsTestApplication.class, args);
	}
	
	@SqsListener("my-first-queue")
	public void listen(String message) {
		System.out.println(message);
	}

}
