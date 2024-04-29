//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.repository.abstracts;

import com.questionnairePortal.entities.concretes.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
}
