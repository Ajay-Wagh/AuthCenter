package com.ajaywagh.authcenter.configurations.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "auditDbEntityManagerFactory",
        transactionManagerRef = "auditDbTransactionManager",
        basePackages = "com.ajaywagh.authcenter.log.audit.repository"
)
public class AuditDbConfig {

    @Value("${spring.audit-datasource.jpa.hibernate.ddl-auto}")
    String HIBERNATE_DDL_AUTO;


    @Bean
    @ConfigurationProperties(prefix="spring.audit-datasource")
    public DataSource auditDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean auditDbEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(auditDbDataSource());
        em.setPackagesToScan("com.ajaywagh.authcenter.log.audit.model");
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                HIBERNATE_DDL_AUTO);
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager auditDbTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                auditDbEntityManagerFactory().getObject());
        return transactionManager;
    }

}
