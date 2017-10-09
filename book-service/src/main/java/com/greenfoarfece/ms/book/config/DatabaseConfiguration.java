package com.greenfoarfece.ms.book.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = {"com.greenfoarfece.ms.book.repo"}
)
public class DatabaseConfiguration {
	
	/**
	 * Datasource bean.
	 * 
	 * @param env - spring environment for injecting properties value.
	 * @return {@link HikariDataSource} object.
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource(Environment env) {
		HikariConfig dsConfig = new HikariConfig();
		dsConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
		dsConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
		dsConfig.setUsername(env.getRequiredProperty("db.username"));
		dsConfig.setPassword(env.getRequiredProperty("db.password"));
		return new HikariDataSource(dsConfig);
	}
	
	/**
	 * Entity manager factory bean.
	 * 
	 * @param ds - the data source.
	 * @param env - spring environment.
	 * @return {@link LocalContainerEntityManagerFactoryBean} object.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, Environment env) {
		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setDataSource(ds);
		emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emFactory.setPackagesToScan("com.greenfoarfece.ms.book.model");
		emFactory.setJpaProperties(jpaProperties(env));
		return emFactory;
	}
	
	/**
	 * Transaction manager bean.
	 * 
	 * @param emFactory - the entity manager factory.
	 * @return {@link JpaTransactionManager} object.
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emFactory);
		return txManager;
	}
	
	/**
	 * Hibernate JPA properties.
	 * 
	 * @param env - spring environment.
	 * @return {@link Properties} object.
	 */
	private Properties jpaProperties(Environment env) {
		Properties props = new Properties();
		props.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		props.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		props.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
		props.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		props.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		return props;
	}
	
}
