package local.mcelroyian.apolloscratch.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long surveyid;

    @Column(nullable = false, unique = true)
    private String date;

    @ManyToOne
    @JoinColumn(name = "topicid",
                nullable = false)
    @JsonIgnoreProperties(value = "surveys")
    @JsonIgnore
    private Topic topic;

    public Survey() {
    }

    public Survey(String date, Topic topic) {
        this.date = date;
        this.topic = topic;
    }

    public long getSurveyid() {
        return surveyid;
    }

    public void setSurveyid(long surveyid) {
        this.surveyid = surveyid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "{" +
                "surveyid=" + surveyid +
                ", date='" + date + '\'' +
                '}';
    }
}
