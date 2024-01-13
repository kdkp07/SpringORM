package in.spring.orm.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "sid")
    private int sid;
    @Column(name = "sname")
    private String sname;
    @Column(name = "scity")
    private String scity;

    public Student(int sid, String sname, String scity) {
        this.sid = sid;
        this.sname = sname;
        this.scity = scity;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }


}
