package local.mcelroyian.apolloscratch.models;

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
        return "Survey{" +
                "surveyid=" + surveyid +
                ", date='" + date + '\'' +
                ", topic=" + topic +
                '}';
    }
}
