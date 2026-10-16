package com.example.JWTNIKHIL.Service;


import com.example.JWTNIKHIL.Entity.UserUS;
import com.example.JWTNIKHIL.Repository.UserUsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserUsRepository userUsRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            UserUS user = userUsRepository.findByUserName(username);
            if(user==null){
                 throw new UsernameNotFoundException(
                         "User not Found" + username
                 );
            }
            return User.
                    withUsername(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().name())
                    .build();
    }
}
