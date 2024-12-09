package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.kafka.annotation.KafkaListener;

import com.app.constant.AppConstant;
import com.app.model.EmployeeDTO;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class TestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServicesApplication.class, args);
	}
	@KafkaListener(topics = AppConstant.TOPIC, groupId="group_emp_details_topic")
	public void subscribeMsg(String order) {
		System.out.print("*** Msg Recieved From Kafka *** :: ");
		System.out.println(order);
		//logic
	}
}
