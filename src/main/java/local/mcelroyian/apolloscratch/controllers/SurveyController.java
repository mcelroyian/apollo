package local.mcelroyian.apolloscratch.controllers;

import local.mcelroyian.apolloscratch.models.Survey;
import local.mcelroyian.apolloscratch.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepo;

    @GetMapping(value = "/surveys/all", produces = {"application/json"})
    public ResponseEntity<?> getSurveys() {

        List<Survey> surveys = new ArrayList<>();

        surveyRepo.findAll().iterator().forEachRemaining(surveys::add);

        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }
}
