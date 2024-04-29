//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.controller.concretes;

import com.questionnairePortal.business.concretes.QuestionnaireAnswersService;
import com.questionnairePortal.entities.concretes.QuestionnaireAnswers;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaireAnswersController")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionnaireAnswersController {

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    //yazılan serviceleri frontendde kullanmak için döndürdüm
    @PostMapping("/saveAnswers")
    public ResponseEntity<String> saveAnswers(@RequestParam String username, @RequestParam int questionId, @RequestParam String answer) {

        return questionnaireAnswersService.saveAnswers(username, questionId, answer);
    }

    @GetMapping("/getOptionsCount")
    public DataResult<List<QuestionnaireAnswers>> getOptionsCount(@RequestParam int optionId) {

        return questionnaireAnswersService.getOptionsCount(optionId);
    }

}
