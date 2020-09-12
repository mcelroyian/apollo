package local.mcelroyian.apolloscratch.models;

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
    private User owner;

    @OneToMany(mappedBy = "topic",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Survey> surveys = new ArrayList<>();

    public Topic() {
    }

    public Topic(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicid=" + topicid +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", surveys=" + surveys +
                '}';
    }
}
