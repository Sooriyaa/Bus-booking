package com.usecase.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableJpaRepositories
@ActiveProfiles("${profile}")
public class ApplicationConfig
{

   @Autowired
   private Environment environment;
   @Autowired
   private DataSource dataSource;
   @Autowired
   private  LocalContainerEntityManagerFactoryBean entityManagerFactory;

   @Bean
   public DataSource dataSource()
   {

      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(environment.getProperty("db.driver"));
      dataSource.setUrl(environment.getProperty("db.url"));
      dataSource.setUsername(environment.getProperty("db.username"));
      dataSource.setPassword(environment.getProperty("db.password"));
      return dataSource;
   }

   /**
    * Declare the JPA entity manager factory.
    */
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory()
   {

      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);

      LocalContainerEntityManagerFactoryBean entityManagerFactory =
         new LocalContainerEntityManagerFactoryBean();
      entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

      // Hibernate properties
      Properties additionalProperties = new Properties();
      additionalProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
      additionalProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
      //additionalProperties.put("hibernate.format_sql",
      //   environment.getProperty("hibernate.format_sql"));
      //additionalProperties.put("hibernate.cache.provider_class",
      //   environment.getProperty("hibernate.cache.provider_class"));
      //additionalProperties.put("hibernate.id.new_generator_mappings",
      //   environment.getProperty("hibernate.id.new_generator_mappings"));
      additionalProperties.put("hibernate.ddl-auto",
         environment.getProperty("hibernate.ddl-auto"));

      entityManagerFactory.setJpaProperties(additionalProperties);

      entityManagerFactory
         .setPackagesToScan(environment.getProperty("entitymanager.packagesToScan"));
      entityManagerFactory.setDataSource(dataSource);
      return entityManagerFactory;
   }

   /**
    * Declare the transaction manager.
    */
   @Bean
   public JpaTransactionManager transactionManager()
   {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
      return transactionManager;
   }
   
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
   {
      return new PersistenceExceptionTranslationPostProcessor();
   }


}
