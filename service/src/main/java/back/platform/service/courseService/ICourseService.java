package back.platform.service.courseService;

import back.platform.model.course.Course;
import back.platform.model.course.CourseForm;
import back.platform.model.question.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> findAll();

    Optional<Course> findById(Long course_ID);

    ResponseEntity<?> saveCourse(CourseForm courseForm);

    ResponseEntity<?> updateCourse(Course course);

    Boolean deleteCourse(Long course_ID);

    Boolean courseExistsById(Long course_ID);
}
