//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Users")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "Users" })
public class Users {
    //user entity sınıfı
    @Id
    @Column(columnDefinition = "TINYINT" , name = "id")
    @NotNull
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

}

