//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.repository.abstracts;

import com.questionnairePortal.entities.concretes.QuestionnaireAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireAnswersRepository extends JpaRepository<QuestionnaireAnswers, Integer> {

    List<QuestionnaireAnswers> getByUserId(int userId);

    List<QuestionnaireAnswers> getByOptionId(int optionId);

    @Query(value = "SELECT COUNT(*) as count FROM questionnaire_answers WHERE optionId= :optionId ", nativeQuery = true)
    int getOptionCountByOptionId(@Param(value = "optionId") int optionId);
}
