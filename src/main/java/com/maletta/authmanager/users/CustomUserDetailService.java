package com.maletta.authmanager.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService
{
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
