//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.controller.concretes;

import com.questionnairePortal.business.concretes.OptionsService;
import com.questionnairePortal.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optionsController")
@CrossOrigin(origins = "http://localhost:3000")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    //yazılan serviceleri frontendde kullanmak için döndürdüm
    @GetMapping("/getOptionIdByOptionTextAndQuestionId")
    public DataResult<Integer> getOptionIdByOptionTextAndQuestionId(@RequestParam String option, @RequestParam int questionId){
        return optionsService.getOptionIdByOptionTextAndQuestionId(option, questionId);
    }

    @GetMapping("/getOptionCountByOptionTextAndQuestionId")
    public Integer getOptionCountByOptionTextAndQuestionId(@RequestParam String option, @RequestParam int questionId){
        return optionsService.getOptionCountByOptionTextAndQuestionId(option, questionId);
    }
}
