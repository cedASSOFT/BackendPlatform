package back.platform.model.test;

import back.platform.model.lesson.Lesson;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "tests")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_ID;

    private String link;

    private String name;

    @ManyToOne
    private Lesson lesson;

    public Test() {
    }

    public Test(String link, String name, Lesson lesson) {
        this.link = link;
        this.name = name;
        this.lesson = lesson;
    }

    public Long getTest_ID() {
        return test_ID;
    }

    public void setTest_ID(Long test_ID) {
        this.test_ID = test_ID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Test{" +
                "test_ID=" + test_ID +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", lesson=" + lesson +
                '}';
    }
}
