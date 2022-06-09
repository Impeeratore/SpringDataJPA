package co.develhope.SpringDataJPA.entities;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public Classes() {
    }

    public Classes(long id, String title, String description, List<Enrollment> enrollment) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.enrollment = enrollment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private List<Enrollment> enrollment;
}
