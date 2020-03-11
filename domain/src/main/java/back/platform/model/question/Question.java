package back.platform.model.question;

import back.platform.model.response.Response;
import back.platform.model.test.Test;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_ID;
    private String title;
    @ManyToOne
    private Test test;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Collection<Response> responses;

    public Question() {
    }

    public Question(String title, Test test, Collection<Response> responses) {
        this.title = title;
        this.test = test;
        this.responses = responses;
    }

    public Long getQuestion_ID() {
        return question_ID;
    }

    public void setQuestion_ID(Long question_ID) {
        this.question_ID = question_ID;
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
                "question_ID=" + question_ID +
                ", title='" + title + '\'' +
                ", test=" + test +
                ", responses=" + responses +
                '}';
    }
}
