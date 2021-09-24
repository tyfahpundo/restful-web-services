package zw.co.afrosoft.restfulwebservices.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UpdateUserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<String, UserResponse> users;
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1")int page,
                           @RequestParam(value = "limit", defaultValue = "10")int limit){
        return "getUser was called";
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse>  getUserById(@PathVariable String userId){
        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
        }else
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponse returnValue = new UserResponse();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if(users == null){
            users = new HashMap<>();
            users.put(userId, returnValue);
        }

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails){
        UserResponse storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId,storedUserDetails);

        return storedUserDetails;
    }
    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }
}
