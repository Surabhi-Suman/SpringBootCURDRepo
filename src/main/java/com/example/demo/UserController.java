package com.example.demo;

import com.example.demo.dao.UserRepo;
import com.example.demo.dao.entities.UserEntity;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserRepo repo;

    @PostMapping(value = "/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user)
    {
        UserEntity userEntity= new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
       // userEntity.setUuid(String.valueOf(Math.random()));
       UserEntity persistedEntiy= repo.saveAndFlush(userEntity);
      // user.setUuid(String.valueOf(persistedEntiy.getUuid()));
        return new ResponseEntity<Object>(persistedEntiy, HttpStatus.OK);
    }

    @GetMapping(value="/getAllUsers")
    public ResponseEntity<?> getUsers(){
        List<UserEntity> listOfUsers= repo.findAll();
        return new ResponseEntity<Object>(listOfUsers, HttpStatus.OK);

    }

    


}
