package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.app.constant.AppConstant;
import com.app.model.EmployeeDetails;


@Configuration
public class KafkaConsumerConfig {
	@Bean
	public ConsumerFactory<String, EmployeeDetails> consumerFactory() {

		Map<String, Object> configProps = new HashMap<String, Object>();

		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.HOST);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>());

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, EmployeeDetails> kafkaListnerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, EmployeeDetails> factory = 
				new ConcurrentKafkaListenerContainerFactory<>();

		factory.setConsumerFactory(consumerFactory());

		return factory;
	}

}
