package local.mcelroyian.apolloscratch;


import local.mcelroyian.apolloscratch.models.Survey;
import local.mcelroyian.apolloscratch.models.Topic;
import local.mcelroyian.apolloscratch.models.User;
import local.mcelroyian.apolloscratch.services.SurveyService;
import local.mcelroyian.apolloscratch.services.TopicService;
import local.mcelroyian.apolloscratch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private SurveyService surveyService;

    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {
        User u1 = new User("Ryan");
        User u2 = new User("Evan");
        User u3 = new User("Ian");

        u1 = userService.save(u1);
        u2 = userService.save(u2);
        u3 = userService.save(u3);

        Topic t1 = new Topic("Fantasy Football 2020", u1);
        Topic t2 = new Topic("Apollo Team B Standup", u2);
        Topic t3 = new Topic("Vaca", u3);

        t1 = topicService.save(t1);
        t2 = topicService.save(t2);
        t3 = topicService.save(t2);

        Survey s1 = new Survey("2020:12:01", t2);
        Survey s2 = new Survey("2020:12:02", t2);
        Survey s3 = new Survey("2020:12:03", t1);

        s1 = surveyService.save(s1);
        s2 = surveyService.save(s2);
        s3 = surveyService.save(s2);
    }
}
