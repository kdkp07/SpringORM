package in.spring.orm.resources;

import in.spring.orm.dao.StudentDaoImpl;
import in.spring.orm.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class springConfig {

    @Bean(name = "dataSource")
    public static DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("Kuldeep@123");
        return ds;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setAnnotatedClasses(Student.class);
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan("in.spring.orm.entities");     // ye line add ki hai
        factoryBean.setHibernateProperties(new Properties() {{
            setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            setProperty("hibernate.show_sql", "true");
            setProperty("hibernate.hbm2ddl.auto", "update");
        }});
        return factoryBean;
    }

    @Bean
    public HibernateTemplate getTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
//        hibernateTemplate.setCheckWriteOperations(false);       // ye line add ki hai
        hibernateTemplate.setSessionFactory(getFactory().getObject());
        return hibernateTemplate;
    }

    @Bean
    public StudentDaoImpl getStdDao(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setHibernateTemplate(getTemplate());
        return studentDao;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(getFactory().getObject());
        return transactionManager;
    }
}
