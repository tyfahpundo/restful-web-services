package zw.co.afrosoft.restfulwebservices.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;
import zw.co.afrosoft.restfulwebservices.ui.shared.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    Map<String, UserResponse> users;

    Utils utils;
    public UserServiceImpl(){

    }
    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }
    @Override
    public UserResponse createUser(UserDetailsRequestModel userDetails) {
        UserResponse returnValue = new UserResponse();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        String userId = utils.generateUserId();
        returnValue.setUserId(userId);
        if(users == null){
            users = new HashMap<>();
            users.put(userId, returnValue);
        }
        return returnValue;
    }
}
