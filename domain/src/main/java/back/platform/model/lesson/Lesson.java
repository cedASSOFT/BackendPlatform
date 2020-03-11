package back.platform.model.lesson;

import back.platform.model.course.Course;
import back.platform.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lesson_ID;
    private String difficulty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Lesson() {
    }

    public Lesson(String difficulty, Course course, User user) {
        this.difficulty = difficulty;
        this.course = course;
        this.user = user;
    }

    public Long getLesson_ID() {
        return lesson_ID;
    }

    public void setLesson_ID(Long lesson_ID) {
        this.lesson_ID = lesson_ID;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lesson_ID=" + lesson_ID +
                ", difficulty='" + difficulty + '\'' +
                ", course=" + course +
                ", user=" + user +
                '}';
    }
}
