//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.user.service;

import com.questionnairePortal.user.entities.Users;
import com.questionnairePortal.user.repository.UsersRepository;
import com.questionnairePortal.utilities.results.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersManager implements UsersService {
    private final UsersRepository assUsersGetDao;

    @Override
    public DataResult<Users> save(Users assUsers) {
        return null;
    }

    @Override
    public DataResult<Users> getByUserName(String userName) {
        return new SuccessDataResult<Users> (this.assUsersGetDao.getByUserName(userName), "UserName ile kullanıcı bilgisi döndürüldü!");
    }

    @Override
    public DataResult<Users> getByUserPassword(String password) {
        return new SuccessDataResult<Users> (this.assUsersGetDao.getByUserPassword(password), "Password ile kullanıcı bilgisi döndürüldü!");
    }

    @Override
    public Result updatePassword(String newPassword, int id) {
        this.assUsersGetDao.updatePassword(newPassword, id);
        return new SuccessResult("Kullanıcı şifresi güncellendi!!");
    }

    @Override
    public DataResult<Users> getByUserNameAndUserPassword(String userName, String password) {
        //return this.assUsersGetDao.getByPassword(password);
        return new SuccessDataResult<Users> (this.assUsersGetDao.getByUserNameAndUserPassword(userName, password), "Kullanıcı bilgisi döndürüldü!");
    }

}
