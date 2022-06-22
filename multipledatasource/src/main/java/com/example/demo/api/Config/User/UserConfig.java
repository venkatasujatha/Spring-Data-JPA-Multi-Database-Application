package com.example.demo.api.Config.User;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef ="entityManagerFactory",
transactionManagerRef = "transactionManager",
basePackages = {"com.example.demo.UserRepository"}
)
public class UserConfig {
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "data1.datasource")
	public DataSource dataOneSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder build) 
	{
		
		HashMap<String, Object> properties=new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		
		return build.dataSource(dataOneSource()).packages("com.example.demo.Model.User").properties(properties).persistenceUnit("User").build();
	}
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
