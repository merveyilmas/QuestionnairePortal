//Merve Yılmaz, 01.05.2023

package com.questionnairePortal.business.concretes;

import com.questionnairePortal.entities.concretes.Options;
import com.questionnairePortal.entities.concretes.QuestionnaireAnswers;
import com.questionnairePortal.repository.abstracts.OptionsRepository;
import com.questionnairePortal.repository.abstracts.QuestionnaireAnswersRepository;
import com.questionnairePortal.user.repository.UsersRepository;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireAnswersService {

    private final QuestionnaireAnswersRepository questionnaireAnswersRepository;

    private final UsersRepository usersRepository;
    private final OptionsRepository optionsRepository;

    public ResponseEntity<String> saveAnswers(String username, int questionId, String answer) {

        //bu fonksiyon ile kullanıcının anket cevapları veritabanına kaydedilir.
        int userId = usersRepository.getByUserName(username).getId();
        int optionId = optionsRepository.getOptionIdByOptionTextAndQuestionId(answer, questionId);

        System.out.println(questionnaireAnswersRepository.getByUserId(userId));

        //kullanıcı bu anketi daha önce cevaplamış mı kontrol ettim
        for (QuestionnaireAnswers q: questionnaireAnswersRepository.getByUserId(userId)) {

            Options options = optionsRepository.getById(q.getOptionId());
            int questionIdd = options.getQuestions().getId();

            System.out.println("questionIdd: " + questionIdd);

            if(questionIdd == questionId){
                return null;
            }
        }

        //eğer daha önce cevaplanmamışsa cevaplar kaydedilir
        System.out.println("here2");
        QuestionnaireAnswers questionnaireAnswers = new QuestionnaireAnswers();
        questionnaireAnswers.setOptionId(optionId);
        questionnaireAnswers.setUserId(userId);

        questionnaireAnswersRepository.save(questionnaireAnswers);

        return ResponseEntity.ok("Questionnaire saved successfully");

    }

    public DataResult<List<QuestionnaireAnswers>> getOptionsCount(int optionId) {

        return new SuccessDataResult<>(questionnaireAnswersRepository.getByOptionId(optionId), "Returned questionnaireAnswers by optionId.");
    }

}
