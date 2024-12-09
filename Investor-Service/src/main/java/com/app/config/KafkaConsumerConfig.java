package com.app.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConsumerConfig {
//	@Bean
//	public ConsumerFactory<String, EmployeeDetails> consumerFactory() {
//
//		Map<String, Object> configProps = new HashMap<String, Object>();
//
//		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.HOST);
//		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//
//		return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>());
//
//	}
//
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, EmployeeDetails> kafkaListnerFactory() {
//
//		ConcurrentKafkaListenerContainerFactory<String, EmployeeDetails> factory = 
//				new ConcurrentKafkaListenerContainerFactory<>();
//
//		factory.setConsumerFactory(consumerFactory());
//
//		return factory;
//	}

}
