package com.jd;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@RestController
public class ClouldRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClouldRibbonApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Resource
	private RestTemplate restTemplate;
	
	
	 @RequestMapping("/hello")
	 public String hello (String name ){
		 
		 String result=restTemplate.getForObject("http://ORDERSERVICE/order?name="+name,String.class);
		 
		 return result ;
	 }

}

