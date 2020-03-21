package back.platform.model.response;

import back.platform.model.question.Question;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "response")
public class Response implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseID;

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

    public Long getResponseID() {
        return responseID;
    }

    public void setResponseID(Long responseID) {
        this.responseID = responseID;
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
                "responseID=" + responseID +
                ", title='" + title + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                '}';
    }
}
