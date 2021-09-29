package zw.co.afrosoft.restfulwebservices.ui.service;

import zw.co.afrosoft.restfulwebservices.ui.model.request.UserDetailsRequestModel;
import zw.co.afrosoft.restfulwebservices.ui.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserDetailsRequestModel userDetails);
}
