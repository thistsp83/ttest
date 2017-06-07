package com.niit.config;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.niit.model.Product;
//import com.niit.model.Product;
//import com.niit.model.User;
import com.niit.model.*;

@Configuration
@ComponentScan({"com.niit"})
@EnableTransactionManagement
public class MyConfig {
	@Autowired
	@Bean(name ="datasource")
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/MyDbthiru");
		ds.setUsername("sa");
		ds.setPassword(""); 
		return ds;
	}
	private Properties getHibernateProperties() 
	{
        Properties prop = new Properties();
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "update");
        return prop;
   }
	
	@Autowired
	@Bean
    public SessionFactory sessionFactory(DataSource datasource) 
	{
            LocalSessionFactoryBuilder builder =new LocalSessionFactoryBuilder(datasource);
            builder.addProperties(getHibernateProperties());
            //builder.scanPackages("com.niit.OnlineWebBackEnd");
builder.addAnnotatedClass(Product.class);
builder.addAnnotatedClass(User.class);
//builder.addAnnotatedClass(Order.class);
builder.addAnnotatedClass(Supplier.class);
System.out.println("Table Created...");
builder.addAnnotatedClass(Cart.class);
builder.addAnnotatedClass(Category.class);
/*builder.addAnnotatedClass(Supplier.class);
//builder.addAnnotatedClass(User.class);
builder.addAnnotatedClass(Order.class);
builder.addAnnotatedClass(Cart.class);*/
         return builder.buildSessionFactory();
    }
	
	//Create a transaction manager
		@Bean
		@Autowired
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }

}
