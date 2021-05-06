package com.epic.lpconnector.configs;
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties("spring.datasource-write.hikari")
public class HikariMySQLProperties {

    private String poolName;

    private int minimumIdle;

    private int maximumPoolSize;

    private int idleTimeout;

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public int getMinimumIdle() {
		return minimumIdle;
	}

	public void setMinimumIdle(int minimumIdle) {
		this.minimumIdle = minimumIdle;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public int getIdleTimeout() {
		return idleTimeout;
	}

	public void setIdleTimeout(int idleTimeout) {
		this.idleTimeout = idleTimeout;
	}
    
    
}
