package com.epic.lpconnector.queue;

import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory; 
import org.springframework.amqp.rabbit.annotation.RabbitListener; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.epic.ceft.bean.CeftResponse;
import com.epic.ceft.bean.Session; 

@Component
public class ConsumeIssuer {
	ExecutorService  executor = Executors.newCachedThreadPool();
	boolean isretarting =false;
	Logger LOGGER = LoggerFactory.getLogger(ConsumeAcquirer.class);
	
	@Value("${telco.name}")
	public String TELCO;
	 
	 
//	@RabbitListener(queues = "#{@ceft_queue_issuer}" ,concurrency = "#{@concurrent_consumers}" )   //  #{@somePropertyValue}
	@RabbitListener(queues = "ceft_queue_issuer" ,concurrency = "#{@concurrent_consumers}" )   //  #{@somePropertyValue}
	@SendTo("lpq.replies") // used when the client doesn't set replyTo.
	public CeftResponse TierARabbitListener(Session s) {
		CeftResponse ceftResponse = new CeftResponse();
		long startTime = System.currentTimeMillis();   
		try {
			Marker uuid = MarkerFactory.getMarker("");
			LOGGER.info(uuid, "Consumed by TierARabbitListener-"+TELCO+" : {}" ,s.getCeftRequest()); 
			 
			 
			FutureTask<CeftResponse> futureTask = new FutureTask<>(new Callable<CeftResponse>() {
		          @Override
		          public CeftResponse call() throws Exception {
		        	  CeftResponse ceftResponse = new CeftResponse();
		        	   
						int retryCount = 0;
						 
						s.setCeftResponse(ceftResponse);
						
						if(retryCount < 600 && ceftResponse.getResponsecode().equals("ES00")) {
						 
							 
						}else { 
							
						}  
		              return ceftResponse;
		          }
		      }
		      );
			 
		executor.execute(futureTask);  
		
		long endTime  = System.currentTimeMillis();
		  
		ceftResponse.setUuid("");
		boolean flag =true;
		if(flag) {
			ceftResponse = futureTask.get(); 
			LOGGER.info(uuid, "Sent Response : {}" ,ceftResponse); 
			return ceftResponse;
		}else {
			ceftResponse.setResponsecode("ES01");
			ceftResponse.setDescription("Succesfully accepted by "+TELCO);     
			LOGGER.info(uuid, "Sent Response : {}" ,ceftResponse); 
			return ceftResponse;
		}
		  
		}catch (RejectedExecutionException e) {
			ceftResponse.setResponsecode("ES08");
			ceftResponse.setDescription("RejectedExecution Exception occured at TierARabbitListener-"+TELCO);
		} catch (Exception e) {
			e.printStackTrace();
			ceftResponse.setResponsecode("ES09");
			ceftResponse.setDescription("Exception occured at TierARabbitListener-"+TELCO);
		} 
		
		return ceftResponse;
	}
  
 
	
}