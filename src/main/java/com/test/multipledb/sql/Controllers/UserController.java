package com.test.multipledb.sql.Controllers;

import com.test.multipledb.sql.Entity.User;
import com.test.multipledb.sql.Repository.UserRepository;
import com.test.multipledb.sql.Requests.CreateUser;
import com.test.multipledb.sql.Requests.DeleteUserRequest;
import com.test.multipledb.sql.Requests.UpdateUserName;
import com.test.multipledb.sql.Responses.UpdateUserNameResponse;
import com.test.multipledb.sql.Responses.createUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/createUser")
    public ResponseEntity<?> registerUser(@RequestBody CreateUser createUser){
        User user = new User(createUser.getUserName(), createUser.getEmail());
        try {
            userRepository.save(user);
            return ResponseEntity.ok().body(new createUserResponse(true,"user created successfully!"));
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new createUserResponse(false,"user cannot be created !"));
        }
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<?> updateUserName(@RequestBody Long userId){
        try{
            Optional<User> user = userRepository.findById(userId);
            return ResponseEntity.ok().body(user);
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new UpdateUserNameResponse(false,"username cannot be updated!"));
        }
    }


    @PutMapping("/updateUserName")
    public ResponseEntity<?> updateUserName(@RequestBody UpdateUserName updateUserName){
        try{
            userRepository.updateNameByUserName(updateUserName.getNewUserName(),updateUserName.getCurrentUserName());
            return ResponseEntity.ok().body(new UpdateUserNameResponse(true,"username updated!"));
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body("user details could not be fetched!");
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> updateUserName(@RequestBody DeleteUserRequest deleteUserRequest){
        try{
             userRepository.deleteById(deleteUserRequest.getUserId());
            return ResponseEntity.noContent().build();
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new UpdateUserNameResponse(false,"user cannot be deleted!"));
        }
    }



}
