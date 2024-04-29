//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "options")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "options" })
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "option_text", nullable = false)
    private String option_text;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Questions questions;

}
