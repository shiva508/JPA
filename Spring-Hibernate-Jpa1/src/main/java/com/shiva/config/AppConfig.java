package com.shiva.config;

import java.util.Properties;



import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.shiva.entity.Person;


@Configuration
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.shiva.service"),
		@ComponentScan("com.shiva.dao")
})
public class AppConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean geEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
	      factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
	      return factoryBean;
	}
	@Bean
	public JpaTransactionManager geJpaTransactionManager()
	{
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
}
