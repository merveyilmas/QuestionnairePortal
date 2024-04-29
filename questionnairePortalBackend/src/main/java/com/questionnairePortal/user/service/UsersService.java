//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.user.service;

import com.questionnairePortal.user.entities.Users;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.Result;


public interface UsersService {
    DataResult<Users> save(Users users);
    DataResult<Users> getByUserName(String userName);
    DataResult<Users> getByUserPassword(String password);
    Result updatePassword(String newPassword , int id);

    DataResult<Users> getByUserNameAndUserPassword(String userName, String password);
}
