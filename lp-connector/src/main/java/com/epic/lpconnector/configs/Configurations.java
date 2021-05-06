package com.epic.lpconnector.configs;
   
import org.springframework.stereotype.Component;
 

@Component
public class Configurations {
	public final static String entity_package_mysql="com.epic.lpconnector.entity.mysql";
	public final static String repository_package_mysql="com.epic.lpconnector.repository.mysql";  
	
	public static final String PSQ_MOBITEL_A =""; // not using
	public static final String PSQ_MOBITEL_B=""; // not using
  
	public static final String PSQ_MOBITEL_C = "psq.mobitel.tier-a"; // not using
	
	public static String PSQ_TIER_A;
	public static String PSQ_TIER_B;
	  
}
