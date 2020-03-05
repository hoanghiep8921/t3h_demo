package com.example.demo.servicegateway;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "serviceEntityManagerFactory",
        transactionManagerRef = "serviceTransactionManager",
        basePackages = { "com.example.demo.servicegateway.repo" }
)
public class ServiceGateWayConfigDB {

    @Bean(name = "serviceDataSource")
    @ConfigurationProperties(prefix = "service.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "serviceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    serviceEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("serviceDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.example.demo.servicegateway.model")
                        .persistenceUnit("db3")
                        .build();
    }  @Bean(name = "serviceTransactionManager")
    public PlatformTransactionManager serviceTransactionManager(
            @Qualifier("serviceEntityManagerFactory") EntityManagerFactory
                    serviceEntityManagerFactory
    ) {
        return new JpaTransactionManager(serviceEntityManagerFactory);
    }
}