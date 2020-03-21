package back.platform.service.questionService;

import back.platform.model.question.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IQuestionService {

    List<Question> findAll();

    Optional<Question> findQuestionById(Long question_ID);

    Boolean deletedQuestion(Long question_ID);

    Question updateQuestion(Question question);

}
