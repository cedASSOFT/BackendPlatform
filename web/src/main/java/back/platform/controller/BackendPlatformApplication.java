package back.platform.controller;

import back.platform.repository.courseRepository.CourseRepository;
import back.platform.repository.lessonRepository.LessonRepository;
import back.platform.repository.questionRepository.QuestionRepository;
import back.platform.repository.responseRepository.ResponseRepository;
import back.platform.repository.roleRepository.RoleRepository;
import back.platform.repository.testRepository.TestRepository;
import back.platform.repository.userRepository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SuppressWarnings("ALL")
@EntityScan(basePackages = {"back.platform.model.*"})
//@EnableJpaRepositories(basePackageClasses = {UserRepository.class, QuestionRepository.class
//        , LessonRepository.class, TestRepository.class, ResponseRepository.class, RoleRepository.class, CourseRepository.class})
@ComponentScan("back.platform.service.*")
@EnableJpaRepositories(basePackages = {"back.platform.repository.*"})
@SpringBootApplication(scanBasePackages = {"back.platform"})
public class BackendPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendPlatformApplication.class);
    }
}
