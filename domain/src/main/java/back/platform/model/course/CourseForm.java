package back.platform.model.course;

public class CourseForm {
    private String courseName;
    private String courseLink;

    public CourseForm() {
    }

    public CourseForm(String courseName, String courseLink) {
        this.courseName = courseName;
        this.courseLink = courseLink;
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
}
