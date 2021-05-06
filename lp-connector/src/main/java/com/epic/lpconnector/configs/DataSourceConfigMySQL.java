package com.epic.lpconnector.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
 

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
@Configuration
@ConfigurationProperties("spring.datasource-write")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMySQL",
        transactionManagerRef = "transactionManagerMySQL",
        basePackages = {Configurations.repository_package_mysql}
)
public class DataSourceConfigMySQL extends HikariConfigMySQL {

    public DataSourceConfigMySQL(HikariMySQLProperties hikariMySQLProperties) {
        super(hikariMySQLProperties);
    }

    @Bean
    public HikariDataSource dataSourceMySQL() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMySQL(
            final HikariDataSource dataSourceMySQL) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceMySQL);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(Configurations.entity_package_mysql);
            setJpaProperties(JPA_WRITE_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerMySQL(EntityManagerFactory entityManagerFactoryMySQL) {
        return new JpaTransactionManager(entityManagerFactoryMySQL);
    }
}
