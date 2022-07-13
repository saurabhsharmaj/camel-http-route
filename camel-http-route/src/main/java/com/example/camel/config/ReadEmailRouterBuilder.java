package com.example.camel.config;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMultipart;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReadEmailRouterBuilder{

	

		CamelContext context;

		  Logger log = LoggerFactory.getLogger(ReadEmailRouterBuilder.class);

			@PostConstruct
			void setup() throws Exception{
				context = new DefaultCamelContext();
				System.out.println("*******hello********");
				context.addRoutes(new RouteBuilder(){
					public void configure(){
						from("imaps://imap.gmail.com?username=nikskhandelwal1990@gmail.com&password=mdcenmznrurkiwrr&delete=false&unseen=true")
						.process(new org.apache.camel.Processor()
						{
							@Override
							public void process(Exchange exchange) throws Exception {
								org.apache.camel.Message message = exchange.getIn();
								log.info("exchange: ${exchange.dump()}");
								log.info("message: ${message.dump()}");
								System.out.println("*****try to read mail********");
								if(message.getBody() instanceof MimeMultipart){
									MimeMultipart mimeMultipart = (MimeMultipart) message.getBody();
									log.info("mimeMultipart: ${mimeMultipart.dump()}");
								} else {
									String body = (String) message.getBody();
									log.info("body: ${body}");
								}
							}	
							})
						.to("log:newmail");
					}
					});
				
				
			
				
			}

			public void start() {
				context.start();
			}
			
			public void stop() {
				context.stop();
			}
			
		
	}

