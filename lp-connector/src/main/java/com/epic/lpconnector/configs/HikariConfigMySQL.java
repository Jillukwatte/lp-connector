package com.epic.lpconnector.configs;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariConfigMySQL extends HikariConfig {

    protected final HikariMySQLProperties hikariMySQLProperties;

    protected final String PERSISTENCE_UNIT_NAME = "write";

    protected final Properties JPA_WRITE_PROPERTIES = new Properties() {{
//        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//        put("hibernate.hbm2ddl.auto", "update");
//        put("hibernate.ddl-auto", "update");
//        put("show-sql", "true");
    }};

    protected HikariConfigMySQL(HikariMySQLProperties hikariMySQLProperties) {
        this.hikariMySQLProperties = hikariMySQLProperties;
        setPoolName(this.hikariMySQLProperties.getPoolName());
        setMinimumIdle(this.hikariMySQLProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariMySQLProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariMySQLProperties.getIdleTimeout());
    }
}
