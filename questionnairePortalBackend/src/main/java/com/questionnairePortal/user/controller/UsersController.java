//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.user.controller;

import com.questionnairePortal.user.entities.Users;
import com.questionnairePortal.user.service.UsersService;
import com.questionnairePortal.utilities.results.DataResult;
import com.questionnairePortal.utilities.results.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/UsersController")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class UsersController {
    private final UsersService usersService;

    //user işlemleri için yazılan sorgular bu sayfadan döndürülür

    @GetMapping("/getUserInfoByUserNameAndUserPassword")
    public DataResult<Users> getUserInfoByPassword(@RequestParam String userName, @RequestParam String password) {
        return this.usersService.getByUserNameAndUserPassword(userName, password);
    }

    @GetMapping("/getUserByUserName")
    public DataResult<Users> getUserByUserName(@RequestParam String userName) {
        return this.usersService.getByUserName(userName);
    }

    @GetMapping("/getUserByPassword")
    public DataResult<Users> getUserByPassword(@RequestParam String password) {
        return this.usersService.getByUserPassword(password);
    }

    @GetMapping("/updateUserPassword")
    public Result updateUserPassword(@RequestParam String newPassword, @RequestParam int userId) {
        return this.usersService.updatePassword(newPassword, userId);
    }

    @GetMapping("/tokenControl")
    public Boolean tokenControl() {
        return true;
    }

}
