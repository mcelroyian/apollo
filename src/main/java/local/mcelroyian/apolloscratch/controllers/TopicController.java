package local.mcelroyian.apolloscratch.controllers;

import local.mcelroyian.apolloscratch.models.Topic;
import local.mcelroyian.apolloscratch.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicRepository topicRepo;

    @GetMapping(value = "/topics/all", produces = {"application/json"})
    public ResponseEntity<?> getTopics() {
        List<Topic> topics = new ArrayList<>();

        topicRepo.findAll().iterator().forEachRemaining(topics::add);

        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

}
