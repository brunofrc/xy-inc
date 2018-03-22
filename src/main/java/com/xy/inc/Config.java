package com.xy.inc;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Classe de configuração
 * 
 * @author bruno
 *
 */
@Configuration
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter {

	/**
	 * max pool size
	 */
	public static final int MAXPOOLSIZE = 8;
	/**
	 * max idle time
	 */
	public static final int MAXIDLETIME = 6000;

	/**
	 * bean
	 *
	 * @return
	 */
	@Bean
	public ComboPooledDataSource dataSource() {

		ComboPooledDataSource dataSource = new ComboPooledDataSource("xy-inc");

		try {
			dataSource.setDriverClass("org.postgresql.Driver");
		} catch (PropertyVetoException pve) {

			return null;
		}
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/xyinc");
		dataSource.setUser("postgres");
		dataSource.setPassword("admin");
		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(MAXPOOLSIZE);
		dataSource.setMaxIdleTime(MAXIDLETIME);

		return dataSource;
	}

	/**
	 * bean
	 *
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
		hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.xy.inc.entity");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	/**
	 * Declare the transaction manager.
	 *
	 * @return
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	/**
	 * corsFilter
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**");
	}
}
