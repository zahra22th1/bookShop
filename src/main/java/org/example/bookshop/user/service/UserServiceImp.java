package org.example.bookshop.user.service;

import org.example.bookshop.dto.response.UserResponse;
import org.example.bookshop.dto.resquest.UserLoginRequest;
import org.example.bookshop.dto.resquest.UserRequest;
import org.example.bookshop.excepion.RuleException;
import org.example.bookshop.model.User;
import org.example.bookshop.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;




import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

private final UserRepository userRepository;
public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
}

    @Override
    public UserResponse save(UserRequest userRequest) {
     Optional<User> byUsername = userRepository.findByUsername(userRequest.getUsername());
     if(byUsername.isPresent())
         throw new RuleException("Username.already.exists");
     return createUserResponse(userRepository.save(createUser(userRequest)));
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
     User user =   userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new RuleException("user.not.found"));
        if(!user.getPassword().equals(userLoginRequest.getPassword())){
            throw new RuleException("password.login.error");
        }
    }

    @Override
    public void changeEnable(Boolean enable, Long id) {
        User user =   userRepository.findById(id).orElseThrow(() -> new RuleException("User.login.error"));
        user.setEnable(enable);
        userRepository.save(user);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    private UserResponse createUserResponse(User user) {
      return UserResponse.builder()
              .id(user.getId())
              .username(user.getUsername())
              .build();
    }
    private User createUser(UserRequest userRequest) {
      return   User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();
    }
}
