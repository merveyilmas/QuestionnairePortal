//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.user.repository;

import com.questionnairePortal.user.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    //user repository sınıfı, user işlemleri için veritabanı sorguları yazılır
    Users getByUserNameAndUserPassword(String userName, String password);
    Users getByUserName(String userName);
    Users getByUserPassword(String password);

    @Modifying
    @Transactional
    @Query("UPDATE Users SET userPassword = :newPassword WHERE id = :id")
    void updatePassword(@Param("newPassword") String newPassword, @Param("id") int id);

}
