package local.mcelroyian.apolloscratch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String name;

    private String email;

    @OneToMany(mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties({"owner", "members"})
    private List<Topic> leadertopics = new ArrayList<>();

    @ManyToMany(mappedBy = "members")
    @JsonIgnoreProperties("members")
    private List<Topic> membertopics = new ArrayList<>();


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }




    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLeadertopics(List<Topic> leadertopics) {
        this.leadertopics = leadertopics;
    }

    public List<Topic> getMembertopics() {
        return membertopics;
    }

    public void setMembertopics(List<Topic> membertopics) {
        this.membertopics = membertopics;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", leadertopics=" + leadertopics +
                ", membertopics=" + membertopics +
                '}';
    }
}
