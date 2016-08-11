package springcourse.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"springcourse.jdbc"})
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class SpringJdbcConfig {

	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:derby://localhost:1527/JavaTunesDB");
		dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		dataSource.setUsername("guest");
		dataSource.setPassword("password");
		return(dataSource);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return(jdbcTemplate);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.DerbyDialect");
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(false);
		LocalContainerEntityManagerFactoryBean emf =	new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource()); // assume defined elsewhere
		emf.setPersistenceUnitName("javatunes");
		emf.setJpaVendorAdapter(vendorAdapter);
		return emf;
	}
	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}

