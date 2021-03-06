package com.tcs.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.tcs.customerservice.config.EndpointSettings;


@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.tcs.customerservice.repository")
@EntityScan(basePackages="com.tcs.customerservice.model")
public class CustomerServiceApplication {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public EndpointSettings setEndpoints() {
		String orderServiceEndpoint = discoveryClient.getInstances("OrderService").get(0).getUri().toString();
		return new EndpointSettings(orderServiceEndpoint);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
