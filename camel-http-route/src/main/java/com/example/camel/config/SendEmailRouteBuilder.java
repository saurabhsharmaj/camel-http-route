package com.example.camel.config;

//import static org.assertj.core.api.Assertions.from;

import org.apache.camel.builder.RouteBuilder;

public class SendEmailRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:C:/inputFolder?noop=true").doTry().setHeader("subject", simple("Java spring with apache camel"))
				.setHeader("to", simple("0405nickykhandelwal@gmail.com"))
				.to("smtps://smtp.gmail.com:465?username=nikskhandelwal1990@gmail.com&password=mdcenmznrurkiwrr");
	}
	
	
	
	
	
	
}
