package com.epic.lpconnector.queue;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epic.ceft.bean.CeftResponse;
import com.epic.ceft.bean.Session; 
@Service
public class ProduceAcquirer {
	  
	@Autowired
	private RabbitTemplate rabbitTemplate; 
	@Value("${lps.rabbitmq.routingkey}")
	private String routingkey;	
	 
 
	public CeftResponse ConvertAndSendtoConsumer(Session s) {
		CeftResponse ceftResponse=new CeftResponse(); 
		try { 
 
			MessagePostProcessor msgPost = new MessagePostProcessor() {
				@Override
				public Message postProcessMessage(Message message) throws AmqpException {
					message.getMessageProperties().setPriority(10);
//					message.getMessageProperties().setExpiration(String.valueOf(s.getReqSms().getTtlqueue()*60000)); //miliseconds TTL TimetoLive working
					return message;
				}};
		   
			
				ceftResponse = (CeftResponse) rabbitTemplate.convertSendAndReceive("ex.acquirer", routingkey, s, msgPost);
			
			try {
				ceftResponse.setUuid(s.getCeftRequest().getUuid());
				ceftResponse.setDescription(ceftResponse.getDescription()); 
				ceftResponse.setResponsecode(ceftResponse.getResponsecode());
			} catch (NullPointerException e) {
				ceftResponse.setUuid(s.getCeftRequest().getUuid());
				ceftResponse.setDescription("Exception occured when sending to consumer, Recieved null response"); 
				ceftResponse.setResponsecode("EA12");
				return ceftResponse;
			} 
		} catch (Exception e) { 
			e.printStackTrace();
			ceftResponse.setUuid(s.getCeftRequest().getUuid());
			ceftResponse.setDescription("Exception occured when sending to consumer"); 
			ceftResponse.setResponsecode("EA13");
		}
		return ceftResponse;
		

	}
	  

}