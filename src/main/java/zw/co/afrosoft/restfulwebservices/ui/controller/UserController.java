package zw.co.afrosoft.restfulwebservices.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UpdateUserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;
import zw.co.afrosoft.restfulwebservices.ui.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<String, UserResponse> users;

    @Autowired
    UserService userService;
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
        UserResponse returnValue = userService.createUser(userDetails);
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
