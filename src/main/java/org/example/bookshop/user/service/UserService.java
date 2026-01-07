package org.example.bookshop.user.service;

import jakarta.validation.Valid;
import org.example.bookshop.dto.response.UserResponse;
import org.example.bookshop.dto.resquest.UserLoginRequest;
import org.example.bookshop.dto.resquest.UserRequest;
import org.example.bookshop.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    UserResponse save(UserRequest userRequest);

    void login(UserLoginRequest userLoginRequest);

    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);


}

