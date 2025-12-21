package org.example.bookshop.user.service;

import org.example.bookshop.dto.response.UserResponse;
import org.example.bookshop.dto.resquest.UserRequest;
import org.example.bookshop.excepion.RuleException;
import org.example.bookshop.model.User;
import org.example.bookshop.repository.UserRepository;
import org.springframework.stereotype.Service;

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
