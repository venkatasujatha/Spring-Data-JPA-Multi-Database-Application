package com.example.demo.api.config.book;

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
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef ="dataTwoentityManagerFactory",
transactionManagerRef = "dataTwotransactionManager",
basePackages = {"com.example.demo.BookRepository"}
)

public class BookConfig 
{
	
	@Bean
	@ConfigurationProperties(prefix = "data2.datasource")
	public DataSource dataTwoDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	
	public LocalContainerEntityManagerFactoryBean dataTwoentityManagerFactory(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder) 
	{
		
		HashMap<String, Object> properties1=new HashMap<>();
		properties1.put("hibernate.hbm2ddl.auto","create");
		properties1.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		
		return builder.dataSource(dataTwoDataSource()).packages("com.example.demo.Model.Book").properties(properties1).persistenceUnit("Book").build();
	}
	@Bean
	
	public PlatformTransactionManager dataTwotransactionManager(@Qualifier("dataTwoentityManagerFactory") EntityManagerFactory entityManagerFactory1) {
		return new JpaTransactionManager(entityManagerFactory1);
	}
}
