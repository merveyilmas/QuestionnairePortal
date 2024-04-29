//Merve Yılmaz, 01.05.2023

package com.questionnairePortal.business.concretes;

import com.questionnairePortal.entities.concretes.Questionnaires;
import com.questionnairePortal.entities.concretes.Questions;
import com.questionnairePortal.entities.dtos.QuestionnairesDto;
import com.questionnairePortal.entities.dtos.QuestionsDto;
import com.questionnairePortal.repository.abstracts.QuestionnairesRepository;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnairesService {

    private final QuestionnairesRepository questionnairesRepository;

    public ResponseEntity<String> createQuestionnaire(@RequestBody QuestionnairesDto questionnairesDto) {

        //bu fonksiyon ile frontend de oluşturulan anketi ilgili dtoları kullanarak veri tabanına kaydediyorum
       System.out.println("questionnaire: " + questionnairesDto);

        // Convert the DTO to an entity
        Questionnaires questionnaires = new Questionnaires();
        questionnaires.setTitle(questionnairesDto.getTitle());

        List<Questions> questions = new ArrayList<>();

        for (QuestionsDto questionDto : questionnairesDto.getQuestions()) {
            Questions question = new Questions();
            question.setQuestion_text(questionDto.getQuestion_text());
            question.setOptions(questionDto.getOptions());
            questions.add(question);
        }
        questionnaires.setQuestions(questions);

        // veri tabanına kaydeder
        questionnairesRepository.save(questionnaires);

        return ResponseEntity.ok("Questionnaire saved successfully");
    }

    public DataResult<Questionnaires> getQuestionnaireByTitle(String title) {
        //seçilen anket başlığı ile anket bilgilerini döndürür
        return new SuccessDataResult<>(questionnairesRepository.getByTitle(title), "Başlık ile anket bulundu.");
    }

    public List<?> getAllTitlesOfQuestionnaires() {
        //anket cevaplama ve sonuçları görme sayfalarında anketi seçmek için başlıklarını döndürdüm
        return questionnairesRepository.getAllTitlesOfQuestionnaires();
    }
}
