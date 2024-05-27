package com.jacinth.online_bookstore.security.config;

import com.jacinth.online_bookstore.entities.Authority;
import com.jacinth.online_bookstore.entities.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@AllArgsConstructor
@Slf4j
public class SecureUser implements UserDetails {

    private final User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        // Add default role
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // Map user authorities to GrantedAuthority objects
        if (user != null && user.getAuthorities() != null) {
            for (Authority authority : user.getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
        }
        return authorities;
    }

    public long getUserId(){
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
