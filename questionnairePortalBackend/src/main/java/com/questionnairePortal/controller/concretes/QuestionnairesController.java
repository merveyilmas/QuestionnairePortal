//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.controller.concretes;

import com.questionnairePortal.business.concretes.QuestionnairesService;
import com.questionnairePortal.entities.concretes.Questionnaires;
import com.questionnairePortal.entities.dtos.QuestionnairesDto;
import com.questionnairePortal.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnairesController")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionnairesController {

    @Autowired
    private QuestionnairesService questionnairesService;

    //yazılan serviceleri frontendde kullanmak için döndürdüm
    @PostMapping("/createQuestionnaire")
    public ResponseEntity<String> createQuestionnaire(@RequestBody QuestionnairesDto questionnairesDto) {
        System.out.println("controller: " + questionnairesDto);
        return questionnairesService.createQuestionnaire(questionnairesDto);
    }

    @GetMapping("/getQuestionnaireByTitle")
    public DataResult<Questionnaires> getQuestionnaireByTitle(@RequestParam String title) {

        return this.questionnairesService.getQuestionnaireByTitle(title);
    }

    @GetMapping("/getAllTitlesOfQuestionnaires")
    public List<?> getAllTitlesOfQuestionnaires() {

        return this.questionnairesService.getAllTitlesOfQuestionnaires();
    }
}
