
package emergon.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement//Inform Spring container to take into account annotations about @Transactional
public class DatabaseConfig {
    
    //datasource
    public DataSource dataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/sales?serverTimezone=Europe/Athens");
        datasource.setUsername("tasos");
        datasource.setPassword("TasKlad123");
        return datasource;
    }
    
    //hibernate properties 
    private Properties hibernateProperties(){
        //Properties object is something like a HashMap
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
    //SessionFactory
    @Bean (name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("emergon.entity");
        return sessionFactory;
    }
    
    //method to take care of transactions
    @Bean  //make HibernateTransacionManager a bean in order to fo into Spring Container
    @Autowired //Inject SessionFactory into that method
    public HibernateTransactionManager transactionManager(SessionFactory s){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}