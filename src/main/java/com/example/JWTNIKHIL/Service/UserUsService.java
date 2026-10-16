package com.example.JWTNIKHIL.Service;


import com.example.JWTNIKHIL.Entity.Roles;
import com.example.JWTNIKHIL.Entity.UserUS;
import com.example.JWTNIKHIL.Repository.UserUsRepository;
import lombok.Lombok;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserUsService {
    private final UserUsRepository userUsRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void saveUser(UserUS userUS){
        userUS.setRoles(Roles.USER);
        userUS.setPassword(passwordEncoder.encode(userUS.getPassword()));
        userUsRepository.save(userUS);
    }

    public String Login(UserUS userUS){
        Authentication authentication=authenticationManager.
                authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userUS.
                                        getUserName(),
                                userUS.
                                        getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(
                    authentication.getName()
            );
        }

        throw new BadCredentialsException("Invalid credentials");
    }

    public List<UserUS> GetAll(){
        return userUsRepository.findAll();
    }

    public UserUS Get(Long ID){
        return userUsRepository.findById(ID).orElse(null);
    }

    public void Delete(Long ID){
        userUsRepository.deleteById(ID);
    }
}
