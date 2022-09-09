package io.javaExpert.InfoService.KafkaConfigure;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import io.javaExpert.InfoService.Model.Info;


@Configuration
public class KafkaConfigure {
	private static 	final String bootstrapServers ="127.0.0.1:9092";
	public static final String TestTopic="TestTopic";

	  @Bean 
	  public KafkaTemplate<String, Info> KafkaTemplate() { return new
	  KafkaTemplate<>(ProducerFactory()); }
	  
	  @Bean 
	  public ProducerFactory<String, Info> ProducerFactory() {
		  

	  Map<String, Object> config = new HashMap<>();
	  config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	  config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	  StringSerializer.class);
	  config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	  JsonSerializable.class); return new DefaultKafkaProducerFactory<String,
	  Info>(config); }
	 
}
