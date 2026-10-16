package com.example.JWTNIKHIL.Controller;


import com.example.JWTNIKHIL.Entity.UserUS;
import com.example.JWTNIKHIL.Service.UserUsService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserUs")
@RequiredArgsConstructor
public class UserUsController {
    private final UserUsService userUsService;

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("EveryThing is good", HttpStatus.OK);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<?> GetAllUser(){
        List<UserUS> userUSES = userUsService.GetAll();
        return new ResponseEntity<>(userUSES, HttpStatus.OK);
    }

    @GetMapping("/GetById/{ID}")
    public ResponseEntity<?> GetByID(@PathVariable Long ID){
        UserUS get = userUsService.Get(ID);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> SignUp(@RequestBody UserUS userUS){
        userUsService.saveUser(userUS);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody UserUS userUS){
        String token = userUsService.Login(userUS);

        return ResponseEntity.ok(
                java.util.Map.of("token", token)
        );
    }

    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long ID){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
