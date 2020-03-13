package back.platform.model.response;

import back.platform.model.question.Question;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "response")
public class Response implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long response_ID;
    private String title;
    private Boolean correct;
    @ManyToOne
    private Question question;

    public Response() {
    }

    public Response(String title, Boolean correct, Question question) {
        this.title = title;
        this.correct = correct;
        this.question = question;
    }

    public Long getResponse_ID() {
        return response_ID;
    }

    public void setResponse_ID(Long response_ID) {
        this.response_ID = response_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Response{" +
                "response_ID=" + response_ID +
                ", title='" + title + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
