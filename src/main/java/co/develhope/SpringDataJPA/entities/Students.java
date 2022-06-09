package co.develhope.SpringDataJPA.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String fistName;

    @Column(unique = true, nullable = false)
    private String email;

    public Students(){}

    public Students(long id, String lastName, String fistName, String email, List<Enrollment> enrollment) {
        this.id = id;
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
        this.enrollment = enrollment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Enrollment> enrollment;
}
