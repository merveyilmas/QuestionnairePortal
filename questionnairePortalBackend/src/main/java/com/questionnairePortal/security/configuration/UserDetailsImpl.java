//Merve Yılmaz, 01.05.2023
package com.questionnairePortal.security.configuration;

import com.questionnairePortal.user.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    Users users;

    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //rolleri burada tanımlarız; admin, user vb..
        return AuthorityUtils.createAuthorityList("Role_User", "Role_Admin", "Role_Developer-SW", "Role_Developer-HW");
    }

    @Override
    public String getPassword() {
        return users.getUserPassword();
    }

    @Override
    public String getUsername() {
        return users.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
