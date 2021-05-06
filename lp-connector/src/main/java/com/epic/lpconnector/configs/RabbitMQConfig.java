package com.epic.lpconnector.configs;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer; 
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {
	private @Autowired AutowireCapableBeanFactory beanFactory;
	@Value("${spring.rabbitmq.username}")
	String username;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${lps.rabbitmq.routingkey}")
	private String routingkey; 
	@Value("${rmqa.consumer.count}")
	public String rmqa_consumer_count;
	@Bean
	public RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchTenRabbitListenerContainerFactory(ConnectionFactory rabbitConnectionFactory) {
	    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	    factory.setConnectionFactory(rabbitConnectionFactory);
	    factory.setMessageConverter(jsonMessageConverter());
	    
	      factory.setPrefetchCount(5);  //messages are being sent at the same time
//        factory.setConcurrentConsumers(1);
//        factory.setMaxConcurrentConsumers(1);
//        factory.setConsecutiveActiveTrigger(1);
        
	    return factory;
	}
	  
	 
//	@Bean
//    public String ceft_queue_acquirer(){  //Queue name
//		return "ceft_queue_acquirer";   
//    }
//	@Bean
//    public String ceft_queue_issuer(){ 
//		return "ceft_queue_issuer";     
//    }
	
	
	@Bean
    public String concurrent_consumers(){ 
		return rmqa_consumer_count;   
    }
	 
	
	@Bean
	Queue queueAcquirer() { 
		Map<String, Object> args = new HashMap<String, Object>(); 
		return new Queue("ceft_queue_acquirer", true,false,false,args);
	}
	@Bean
	Queue queueIssuer() { 
		Map<String, Object> args = new HashMap<String, Object>(); 
		return new Queue("ceft_queue_issuer", true,false,false,args);
	}
	  
	@Bean
	DirectExchange exchangeAcquirer() {
		return new DirectExchange("ex.acquirer");
	}
	@Bean
	DirectExchange exchangeIssuer() {
		return new DirectExchange("ex.issuer");
	}
	 
	 
	@Bean
	public Binding bindingAcquirer() {
	    return BindingBuilder.bind(queueAcquirer()).to(exchangeAcquirer()).with(routingkey);
	}
	 
	@Bean
	public Binding bindingIssuer() {
	    return BindingBuilder.bind(queueIssuer()).to(exchangeIssuer()).with(routingkey);
	}
	 
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	 
	@Bean 
	public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
	 return  new Jackson2JsonMessageConverter(objectMapper);
	}
	 

	@Bean
    RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) { 
//		connectionFactory.setChannelCacheSize(50); 
//		connectionFactory.getRabbitConnectionFactory().setRequestedChannelMax(100); 
		 
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		 
//		rabbitTemplate.setReplyAddress("psq.reply");
		rabbitTemplate.setReplyTimeout(60000);
		return rabbitTemplate;
    }
	
//	@Bean
//	MessageListenerContainer msgListenerQA(ConnectionFactory connectionFactory ) {
//		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
//		simpleMessageListenerContainer.setQueues(queueA());
//		RabbitMQQAListener rabbitMQQAListner = new RabbitMQQAListener();
//		beanFactory.autowireBean(rabbitMQQAListner);
//		simpleMessageListenerContainer.setMessageListener(rabbitMQQAListner);
//		 
//		return simpleMessageListenerContainer;
//	}
	
//	@Bean
//	MessageListenerContainer msgListenerQB(ConnectionFactory connectionFactory ) {
//		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
//		simpleMessageListenerContainer.setQueues(queueB());
//		RabbitMQQBListener rabbitMQQBListner = new RabbitMQQBListener();
//		beanFactory.autowireBean(rabbitMQQBListner);
//		simpleMessageListenerContainer.setMessageListener(rabbitMQQBListner);
//		return simpleMessageListenerContainer;
//	}
		
}
