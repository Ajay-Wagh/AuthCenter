package com.ajaywagh.authcenter.configurations.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryDbEntityManagerFactory",
        transactionManagerRef = "primaryDbTransactionManager",
        basePackages = "com.ajaywagh.authcenter.datarepositories"
)
public class PrimaryDbConfig {

    @Value("${spring.datasource.jpa.hibernate.ddl-auto}")
    String HIBERNATE_DDL_AUTO;


    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean primaryDbEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDbDataSource());
        em.setPackagesToScan("com.ajaywagh.authcenter.datamodels");
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                HIBERNATE_DDL_AUTO);
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager primaryDbTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                primaryDbEntityManagerFactory().getObject());
        return transactionManager;
    }
}
