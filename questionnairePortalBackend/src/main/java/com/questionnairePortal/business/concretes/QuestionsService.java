//Merve Yılmaz, 01.05.2023

package com.questionnairePortal.business.concretes;

import com.questionnairePortal.repository.abstracts.QuestionnairesRepository;
import com.questionnairePortal.repository.abstracts.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionsRepository questionsRepository;
}
