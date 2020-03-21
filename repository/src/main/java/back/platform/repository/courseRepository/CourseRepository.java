package back.platform.repository.courseRepository;

import back.platform.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findCourseByCourseID(Long course_ID);

    Boolean existsByCourseID(Long course_ID);
}
