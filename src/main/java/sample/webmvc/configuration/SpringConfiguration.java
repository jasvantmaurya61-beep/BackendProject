package sample.webmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@ComponentScan(basePackages   = "sample.webmvc")
@EnableTransactionManagement
@Configuration
public class SpringConfiguration implements WebMvcConfigurer{

 
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/java11");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@123");
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory () {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("sample.webmvc.entity");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	
	}
	
	@Bean
	public HibernateTemplate  hibernateTemplate(SessionFactory sessionFactory) {
		
		return new HibernateTemplate(sessionFactory);
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		
		return new HibernateTransactionManager(sessionFactory);
		
	}
	
	
	@Bean
	public ViewResolver viewResolver () {
	
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//it specifies  that JSTL view should be used .
//jstlView is a class provide by the Spring Framework that is specifically designed to handle JSP page using JSTL.
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/JSP/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
		
	}

}