package zw.co.afrosoft.restfulwebservices.ui.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    Map<String, UserResponse> users;
    @Override
    public UserResponse createUser(UserDetailsRequestModel userDetails) {
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
        return returnValue;
    }
}
