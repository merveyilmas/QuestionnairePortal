//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.security.configuration;

import com.questionnairePortal.user.repository.UsersRepository;
import com.questionnairePortal.user.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersDao;

    //when we accept the authentication request, we need to retrieve the correct identity from the database using the provided credentials and then verify it.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDao.getByUserName(username);

        if(users == null)
            throw new UsernameNotFoundException("User not found!!");
        return new UserDetailsImpl(users);
    }
}
