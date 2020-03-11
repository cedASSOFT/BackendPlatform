package back.platform.model.course;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_ID")
    private Long course_ID;
    private String courseName;
    private String courseLink;

    public Course() {
    }

    public Course(String courseName, String courseLink) {
        this.courseName = courseName;
        this.courseLink = courseLink;
    }

    public Long getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(Long course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_ID=" + course_ID +
                ", courseName='" + courseName + '\'' +
                ", courseLink='" + courseLink + '\'' +
                '}';
    }
}
