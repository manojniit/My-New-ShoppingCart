package com.niit.sonebackend.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.sonebackend.model.Admin;
import com.niit.sonebackend.model.User;
@Configuration
@ComponentScan("com.niit.sonebackend")
@EnableTransactionManagement
public class ApplicationContextConfigure {
public DataSource getDataSource()
{
 DriverManagerDataSource dataSource=new DriverManagerDataSource();
 dataSource.setDriverClassName("org.h2.Driver");
 dataSource.setUrl("jdbc:h2:tcp://localhost/~/manojniit");
 dataSource.setUsername("sa");
 dataSource.setPassword("sa");
 return dataSource;
 
   private Properties getHibernateProperties()
 {
	 Properties properties=new Properties();
	 properties.put("hibernate.show_sql","true");
	 properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 properties.put("hibernate.hdm2ddl.auto","update");
	 return properties;
}
   @Autowired
   @Bean(name="sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource)
     {
	   LocalSessionFactoryBuilder sessionBuilder=new  LocalSessionFactoryBuilder(DataSource);
	   sessionBuilder.addProperties(getHibernateProperties());
	   sessionBuilder.addAnnotatedClass(Admin.class);
	   sessionBuilder.addAnnotatedClass(User.class);
   }
   @Autowired
   @Bean(name="transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
   {
	   HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	   return transactionManager;
   }



}
}
