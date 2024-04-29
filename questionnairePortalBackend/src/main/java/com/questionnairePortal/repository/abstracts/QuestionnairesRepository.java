//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.repository.abstracts;

import com.questionnairePortal.entities.concretes.Questionnaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnairesRepository extends JpaRepository<Questionnaires, Integer> {

    Questionnaires getByTitle(String title);

    @Query("SELECT title FROM questionnaires")
    List<?> getAllTitlesOfQuestionnaires();
}
