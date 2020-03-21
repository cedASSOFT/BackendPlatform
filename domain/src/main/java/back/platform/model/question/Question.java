package back.platform.model.question;

import back.platform.model.response.Response;
import back.platform.model.test.Test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;

    private String title;

    @ManyToOne
    private Test test;

    @OneToMany(mappedBy = "question")
    private Collection<Response> responses;

    public Question() {
    }

    public Question(String title, Test test, Collection<Response> responses) {
        this.title = title;
        this.test = test;
        this.responses = responses;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Collection<Response> getResponses() {
        return responses;
    }

    public void setResponses(Collection<Response> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", title='" + title + '\'' +
                ", test=" + test +
                ", responses=" + responses +
                '}';
    }
}
