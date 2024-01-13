package in.spring.orm.dao;

import in.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class StudentDaoImpl implements StudentDao{

    private HibernateTemplate hibernateTemplate;


    // insert student
    @Override
    public int insert(Student student) {
        int r= (int) this.hibernateTemplate.save(student);
        return r;
    }
}
