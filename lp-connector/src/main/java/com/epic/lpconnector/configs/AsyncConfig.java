package com.epic.lpconnector.configs;
//package com.epic.smssender.configs;
//
//import java.util.concurrent.Executor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//@EnableAsync
//public class AsyncConfig {
//	
//	@Bean(name="taskExecutor")
//	public Executor taskExecutor() {
//		ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(200);
//		executor.setMaxPoolSize(200);
//		executor.setQueueCapacity(200);
//		executor.setThreadNamePrefix("sender-pool");
//		executor.initialize();
//		return executor;
//	}
//}
