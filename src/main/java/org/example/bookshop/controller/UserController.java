package org.example.bookshop.controller;


import jakarta.validation.Valid;
import org.example.bookshop.dto.response.UserResponse;
import org.example.bookshop.dto.resquest.UserLoginRequest;
import org.example.bookshop.dto.resquest.UserRequest;
import org.example.bookshop.model.User;
import org.example.bookshop.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest) {
        return  ResponseEntity.ok(userService.save(userRequest));
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
      userService.login(userLoginRequest);
      return ResponseEntity.ok().build();

    }
    @PutMapping("/enabled/{id}/{enable}")
    public ResponseEntity<?> changeEnableUser(@PathVariable Boolean enable,@PathVariable Long id){
        userService.changeEnable(enable, id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Page<User>> getAllUser(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));

    }
}
