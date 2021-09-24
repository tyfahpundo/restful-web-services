package zw.co.afrosoft.restfulwebservices.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1")int page,
                           @RequestParam(value = "limit", defaultValue = "10")int limit){
        return "getUser was called";
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse>  getUserById(@PathVariable String userId){
        UserResponse returnValue = new UserResponse();
        returnValue.setFirstName("Tafadzwa");
        returnValue.setLastName("Pundo");
        returnValue.setEmail("tyfah@gmail.com");
        returnValue.setUserId("263");

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponse returnValue = new UserResponse();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    public String deleteUser(){
        return "deleteUser was called";
    }
}
