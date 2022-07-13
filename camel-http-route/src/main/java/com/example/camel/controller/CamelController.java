package com.example.camel.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.camel.config.ReadEmailRouterBuilder;
import com.example.camel.config.SendEmailRouteBuilder;

@RestController
public class CamelController {
	
	@Autowired ReadEmailRouterBuilder readEmailRouterBuilder;
	Logger log = LoggerFactory.getLogger(CamelController.class);
	
	@GetMapping("hello")
	public String sayHello() {
		return "hello!!!";
	}
	
	@GetMapping("sendmail")
	public String sendMail() {
		Boolean b=false;
		
		SendEmailRouteBuilder routeBuilder = new SendEmailRouteBuilder();
      CamelContext ctx = new DefaultCamelContext();
      try {
          ctx.addRoutes(routeBuilder);
          ctx.start();
          b=true;
          Thread.sleep(1000);
          ctx.stop();
         
      }
      catch (Exception e) {
          e.printStackTrace();
         
      }
      if(b)
    	  return "mail sent successfully";
      else
    	  return "something went wrong";
	}
	
	@GetMapping("/readmail")
	public void readMail() throws Exception {
		 log.info("Reading message");
		 readEmailRouterBuilder.start();
		  Thread.sleep(1000);
		    readEmailRouterBuilder.stop();
	}
	
	
}
