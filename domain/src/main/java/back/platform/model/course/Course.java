package back.platform.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courses")
@ApiModel(value = "Course entity", description = "All details about user")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated course Id")
    private long courseID;
    @ApiModelProperty(notes = "The field name of the table course")
    private String courseName;
    @ApiModelProperty(notes = "The link of the course")
    private String courseLink;

    public Course() {
    }

    public Course(String courseName, String courseLink) {
        this.courseName = courseName;
        this.courseLink = courseLink;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
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
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseLink='" + courseLink + '\'' +
                '}';
    }
}
