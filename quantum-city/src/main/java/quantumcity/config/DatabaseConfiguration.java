package quantumcity.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import quantumcity.constants.ServerConstants;


@Configuration
public class DatabaseConfiguration {
	@Autowired
	private Environment env;
	
	
	@Bean(name="defaultDataSource")
	public DataSource dataSource() {
		final HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(ServerConstants.DATABASE_DRIVER));
		dataSource.setJdbcUrl(env.getRequiredProperty(ServerConstants.DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(ServerConstants.DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(ServerConstants.DATABASE_PASSWORD));
		
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(env.getRequiredProperty(ServerConstants.ENTITY_MANAGER_PACKAGES_TO_SCAN));
		em.setPersistenceUnitName(ServerConstants.PERSISTENCE_NAME);
		
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") final EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties hibernateProperties() {
		 final Properties hibernateProperties = new Properties();
	     hibernateProperties.put(ServerConstants.HIBERNATE_DIALECT, env.getRequiredProperty(ServerConstants.HIBERNATE_DIALECT));
	     hibernateProperties.put(ServerConstants.HIBERNATE_SHOW_SQL, env.getRequiredProperty(ServerConstants.HIBERNATE_SHOW_SQL));
	     hibernateProperties.put(ServerConstants.HIBERNATE_FORMAT_SQL, env.getRequiredProperty(ServerConstants.HIBERNATE_FORMAT_SQL));
	     hibernateProperties.put(ServerConstants.HIBERNATE_USE_SQL_COMMENTS, env.getRequiredProperty(ServerConstants.HIBERNATE_USE_SQL_COMMENTS));
	     hibernateProperties.put(ServerConstants.HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(ServerConstants.HIBERNATE_HBM2DDL_AUTO));
	     hibernateProperties.put(ServerConstants.HIBERNATE_NON_CONTEXTUAL_LOB, env.getRequiredProperty(ServerConstants.HIBERNATE_NON_CONTEXTUAL_LOB));
	     hibernateProperties.put(ServerConstants.ENABLE_LAZY_LOAD_NO_TRANS, env.getRequiredProperty(ServerConstants.ENABLE_LAZY_LOAD_NO_TRANS));
		 return hibernateProperties;
	}
	
	
}
