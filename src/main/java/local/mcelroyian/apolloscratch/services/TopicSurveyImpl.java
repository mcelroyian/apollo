package local.mcelroyian.apolloscratch.services;

import local.mcelroyian.apolloscratch.models.Topic;
import local.mcelroyian.apolloscratch.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "topicService")
public class TopicSurveyImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepo;

    @Transactional
    @Override
    public Topic save(Topic topic) {
        return topicRepo.save(topic);
    }
}
