package com.epic.lpconnector.validate;
 

public class TPSManager {
	
	 
	public static void controlledSleepforAlert(int maxTps,int maxTpsBulk,boolean isBulkQueueFree,long startTime,long endTime) {
		if (maxTps==0) maxTps=1;  
		int tpsWait = 0;
		long dynamicWait = 0;
		tpsWait = 1000/maxTps ;   //  max Tps for Alert 
//		HTTPClient.isBulkQueueFree(RabbitMQConfig.getQueueName(Configurations.TELCO, "b"))
		if(!isBulkQueueFree) {
			if((maxTps - maxTpsBulk)<1) {
				dynamicWait = 1;
			}else {
				dynamicWait = 1000/(maxTps - maxTpsBulk); 
			}
		}else {
			dynamicWait = tpsWait;		
		} 
		
		dynamicWait = dynamicWait - (endTime - startTime);
		
		if(dynamicWait < 0) {
			dynamicWait = 0;
		} 
		try { 
			Thread.sleep(dynamicWait);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}
	
	public static void controlledSleepforBulk(int maxTps,int maxTpsBulk,long startTime,long endTime) {
		if(maxTps==0) maxTps=1;
		int tpsWait = 0;
		long dynamicWait = 0;
		tpsWait = 1000/maxTpsBulk ;  //  max Tps for Bulk   
		
		if((maxTps - maxTpsBulk)<1) {
			dynamicWait = 1000/tpsWait;
		}else {
			dynamicWait = tpsWait;	
		}
		 
		dynamicWait = dynamicWait - (endTime-startTime);
		
		if(dynamicWait < 0) {
			dynamicWait = 0;
		}
		 
		try {
			System.out.println(maxTps+" - "+maxTpsBulk+" - "+dynamicWait); 
			Thread.sleep(dynamicWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
