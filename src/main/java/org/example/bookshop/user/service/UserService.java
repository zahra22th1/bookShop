package org.example.bookshop.user.service;

import org.example.bookshop.dto.response.UserResponse;
import org.example.bookshop.dto.resquest.UserRequest;
import org.example.bookshop.model.User;

public interface UserService {
    UserResponse save(UserRequest userRequest);
}
