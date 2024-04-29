//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.repository.abstracts;

import com.questionnairePortal.entities.concretes.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer> {

    @Query(value = "SELECT id FROM options WHERE option_text= :optionText and question_id= :questionId ", nativeQuery = true)
    int getOptionIdByOptionTextAndQuestionId(@Param(value = "optionText") String optionText, @Param(value = "questionId") int questionId);

    Options getById(int id);

}
