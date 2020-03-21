package back.platform.service.courseService;

import back.platform.exceptions.notFoundExceptions.CourseNotFoundException;
import back.platform.message.responseMessage.SuccessfulAddedCourse;
import back.platform.message.responseMessage.SuccessfulUpdatedCourse;
import back.platform.model.course.Course;
import back.platform.model.course.CourseForm;
import back.platform.repository.courseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long course_ID) {
        return courseRepository.findCourseByCourseID(course_ID);
    }

    @Override
    public ResponseEntity<?> saveCourse(CourseForm courseForm) {
        Course course = new Course(courseForm.getCourseName(), courseForm.getCourseLink());
        courseRepository.save(course);
        return new ResponseEntity<>(new SuccessfulAddedCourse("Course with name -> " + course.getCourseName() + " added successfully"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCourse(Course course) {
//        if (!courseExistsById(course_ID))
//            throw new CourseNotFoundException("Course with ID " + course_ID + " did not find");

//        Course courseFinded = courseRepository.getOne(course_ID);
        return new ResponseEntity<>(new SuccessfulUpdatedCourse("Course with name -> " + course.getCourseName() + " updated successfully"), HttpStatus.OK);
    }

    @Override
    public Boolean deleteCourse(Long course_ID) {
        if (!courseExistsById(course_ID))
            throw new CourseNotFoundException("Course with ID " + course_ID + " did not find");
        courseRepository.deleteById(course_ID);
        return true;
    }

    @Override
    public Boolean courseExistsById(Long course_ID) {
        return courseRepository.existsByCourseID(course_ID);
    }
}
