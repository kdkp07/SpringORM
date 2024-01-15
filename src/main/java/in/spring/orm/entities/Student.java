package in.spring.orm.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class Student {

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scity='" + scity + '\'' +
                '}';
    }
}
