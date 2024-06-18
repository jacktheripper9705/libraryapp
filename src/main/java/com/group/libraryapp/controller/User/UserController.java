package com.group.libraryapp.controller.User;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
       userService.saveUser(request);
    }

    // "/user" 경로로 GET 요청을 받을 때 실행되는 메서드
    // Controller
    @GetMapping("/user")
   
    public List<UserResponse> getUsers() {
       return userService.getUsers();
    }

    // "/user" 경로로 PUT 요청을 받을 때 실행되는 메서드
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }


    // Controller
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}


