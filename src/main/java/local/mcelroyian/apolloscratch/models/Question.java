package local.mcelroyian.apolloscratch.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import local.mcelroyian.apolloscratch.views.QuestionsType;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionid;

    @Column(nullable = false, unique = true)
    private String body;

    private boolean isleader;

    @Enumerated(EnumType.ORDINAL)
    private QuestionsType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "surveyid",
                nullable = false)
    private Survey survey;

    public Question() {
    }

    public Question(String body, boolean isleader, QuestionsType type, Survey survey) {
        this.body = body;
        this.isleader = isleader;
        this.type = type;
        this.survey = survey;
    }

    public long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(long questionid) {
        this.questionid = questionid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isIsleader() {
        return isleader;
    }

    public void setIsleader(boolean isleader) {
        this.isleader = isleader;
    }

    public QuestionsType getType() {
        return type;
    }

    public void setType(QuestionsType type) {
        this.type = type;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionid=" + questionid +
                ", body='" + body + '\'' +
                ", isleader=" + isleader +
                ", type=" + type +
                ", survey=" + survey +
                '}';
    }
}
