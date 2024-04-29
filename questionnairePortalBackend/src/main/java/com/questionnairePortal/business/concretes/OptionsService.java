//Merve Yılmaz, 01.05.2023

package com.questionnairePortal.business.concretes;

import com.questionnairePortal.repository.abstracts.OptionsRepository;
import com.questionnairePortal.repository.abstracts.QuestionnaireAnswersRepository;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OptionsService {

    private final OptionsRepository optionsRepository;
    private final QuestionnaireAnswersRepository questionnaireAnswersRepository;

    public DataResult<Integer> getOptionIdByOptionTextAndQuestionId(String option, int questionId){
        return new SuccessDataResult<>(optionsRepository.getOptionIdByOptionTextAndQuestionId(option, questionId),"Returned optionId by optionText and questionId.");
    }

    public Integer getOptionCountByOptionTextAndQuestionId( String option, int questionId){
        //frontend de bulunan anket soruları objeinde bulunan seçenek ve soru id sini parametre olarak alıp, kaydedilmiş seçenek cevap sayılarını döndürdüm
        int optionId = optionsRepository.getOptionIdByOptionTextAndQuestionId(option, questionId);
        return questionnaireAnswersRepository.getOptionCountByOptionId(optionId);
    }
}
