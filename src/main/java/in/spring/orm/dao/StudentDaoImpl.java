package in.spring.orm.dao;

import in.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl{

    private HibernateTemplate hibernateTemplate;


    // insert student

    @Transactional(readOnly = false)              // in order to enable write operation
    public int insert(Student student) {

        int r= (int) this.hibernateTemplate.save(student);
        return r;
    }
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
