package back.platform.service.initializationService.initDataService;

import back.platform.model.course.Course;
import back.platform.model.lesson.Lesson;
import back.platform.model.question.Question;
import back.platform.model.response.Response;
import back.platform.model.test.Test;
import back.platform.model.user.AppUser;
import back.platform.repository.courseRepository.CourseRepository;
import back.platform.repository.lessonRepository.LessonRepository;
import back.platform.repository.questionRepository.QuestionRepository;
import back.platform.repository.responseRepository.ResponseRepository;
import back.platform.repository.roleRepository.RoleRepository;
import back.platform.repository.testRepository.TestRepository;
import back.platform.repository.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Component
public class InitDatabaseFeederImpl implements IInitDatabaseFeeder {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initCourse() {
        Stream.of("JavaSE https://docs.oracle.com/javase/tutorial/", "JavaEE https://www.w3schools.com/java/"
                , "PHP https://www.w3schools.com/php/", "Scala https://fr.coursera.org/specializations/scala").forEach(coursename -> {
            Course course = new Course(coursename.split(" ")[0], coursename.split(" ")[1]);
            courseRepository.save(course);
        });
    }

    @Override
    public void initUser() {
    }

    @Override
    public void initLesson() {
        List<Course> courses = courseRepository.findAll();
        List<AppUser> users = userRepository.findAll();

        Stream.of("EASY", "MEDIUM", "EXPERT").forEach(difficulty -> {
            Lesson lesson = new Lesson();
            lesson.setDifficulty(difficulty);
            lesson.setCourse(courses.get(new Random().nextInt(courses.size())));
            lesson.setUser(users.get(new Random().nextInt(users.size())));
            lessonRepository.save(lesson);
        });
    }

    @Override
    public void initTest() {
        List<Lesson> lessons = lessonRepository.findAll();
        Stream.of("Test1 linkTest1", "Test2 linkTest2", "Test3 linkTest3").forEach(testname -> {
            Test test = new Test();
            test.setName(testname.split(" ")[0]);
            test.setLink(testname.split(" ")[1]);
            test.setLesson(lessons.get(new Random().nextInt(lessons.size())));
            testRepository.save(test);
        });
    }


    @Override
    public void initQuestion() {
        List<Test> tests = testRepository.findAll();
        Stream.of("question1", "question2", "question3").forEach(quest -> {
            Question question = new Question();
            question.setTitle(quest);
            question.setTest(tests.get(new Random().nextInt(tests.size())));
            questionRepository.save(question);
        });
    }

    @Override
    public void initResponse() {
        List<Question> questions = questionRepository.findAll();
        Stream.of("response1", "response2", "response3").forEach(resp -> {
            Response response = new Response();
            response.setTitle(resp);
            response.setCorrect(new Random().nextBoolean());
            response.setQuestion(questions.get(new Random().nextInt(questions.size())));
            responseRepository.save(response);
        });
    }

    @Override
    public void initRole() {

    }
}
