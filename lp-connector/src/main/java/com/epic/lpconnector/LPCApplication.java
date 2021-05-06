package com.epic.lpconnector;
 
import org.springframework.amqp.rabbit.annotation.EnableRabbit; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
@EnableRabbit 
public class LPCApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(LPCApplication.class, args);
		  
//		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor"); 
//		CeftAcquirerChannelHandler listenerSMPPSession=context.getBean(CeftAcquirerChannelHandler.class); 
//		taskExecutor.execute(listenerSMPPSession);
		
	}
	
	 
	
}