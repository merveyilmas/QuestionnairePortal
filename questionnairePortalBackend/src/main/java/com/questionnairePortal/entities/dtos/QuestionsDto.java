//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionsDto {
    //anket soruları ve seçeneklerini içeren dto

    private String question_text;
    private List<String> options;
}
