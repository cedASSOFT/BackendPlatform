package back.platform.model.lesson;

import back.platform.model.course.Course;
import back.platform.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lessons")
public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonID;

    private String difficulty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AppUser user;

    public Lesson() {
    }

    public Lesson(String difficulty, Course course, AppUser user) {
        this.difficulty = difficulty;
        this.course = course;
        this.user = user;
    }

    public Long getLessonID() {
        return lessonID;
    }

    public void setLessonID(Long lessonID) {
        this.lessonID = lessonID;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonID=" + lessonID +
                ", difficulty='" + difficulty + '\'' +
                ", course=" + course +
                ", user=" + user +
                '}';
    }
}
