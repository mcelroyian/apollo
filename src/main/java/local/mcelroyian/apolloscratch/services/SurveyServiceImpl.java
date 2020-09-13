package local.mcelroyian.apolloscratch.services;

import local.mcelroyian.apolloscratch.models.Survey;
import local.mcelroyian.apolloscratch.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "surveyService")
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepo;

    @Override
    public Survey save(Survey survey) {
        return surveyRepo.save(survey);
    }
}
