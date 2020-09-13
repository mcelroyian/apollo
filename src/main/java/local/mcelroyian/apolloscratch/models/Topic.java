package local.mcelroyian.apolloscratch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long topicid;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"leadertopics", "membertopics"})
    private User owner;

    @OneToMany(mappedBy = "topic",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties(value = "topic")
    private List<Survey> surveys = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "usertopics",
            joinColumns = @JoinColumn(name = "topicid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonIgnoreProperties("membertopics")
    List<User> members = new ArrayList<>();

    public Topic() {
    }

    public Topic(String name, User owner) {
        this.name = name;
        List<User> myMembers = new ArrayList<>();
        myMembers.add(owner);
        this.setMembers(myMembers);
        this.owner = owner;
    }

    public long getTopicid() {
        return topicid;
    }

    public void setTopicid(long topicid) {
        this.topicid = topicid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "{" +
                "topicid=" + topicid +
                ", name='" + name + '\'' +
                ", surveys=" + surveys +
                '}';
    }
}
