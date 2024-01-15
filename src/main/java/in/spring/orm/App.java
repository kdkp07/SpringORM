package in.spring.orm;

import in.spring.orm.dao.StudentDao;
import in.spring.orm.dao.StudentDaoImpl;
import in.spring.orm.entities.Student;
import in.spring.orm.resources.springConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("in/spring/orm/resources/config.xml");
        StudentDaoImpl studentDao = context.getBean("getStdDao", StudentDaoImpl.class);

        Student student = new Student(112,"Aakash Kumar","Delhi");
        int r = studentDao.insert(student);
        System.out.println("Number of rows affected " + r);
    }
}
