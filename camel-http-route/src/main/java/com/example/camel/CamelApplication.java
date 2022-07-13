package com.example.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.camel.config.SendEmailRouteBuilder;

@SpringBootApplication
public class CamelApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CamelApplication.class, args);
		
		
//		SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
//        CamelContext ctx = new DefaultCamelContext();
//        try {
//            ctx.addRoutes(routeBuilder);
//            ctx.start();
//            Thread.sleep(500 * 60 * 1000);
//            ctx.stop();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

    }
	}

