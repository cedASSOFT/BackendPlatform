package back.platform.controller.courseRestController;

import back.platform.model.course.Course;
import back.platform.model.course.CourseForm;
import back.platform.service.courseService.CourseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/")
public class CourseController {

    private CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("details/cours/{course_ID}")
    public Optional<Course> getOneCourse(@PathVariable Long course_ID) {
        return courseService.findById(course_ID);
    }

    @PostMapping("add/cours")
    public ResponseEntity<?> saveCourse(@RequestBody CourseForm course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("update/cours")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }


}
