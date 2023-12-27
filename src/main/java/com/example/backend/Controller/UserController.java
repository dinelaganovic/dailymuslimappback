package com.example.backend.Controller;

import com.example.backend.Dto.LoginDTO;
import com.example.backend.Dto.UserDTO;
import com.example.backend.Service.UserService;
import com.example.backend.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDto){
        String user=userService.createUser(userDto);
        return user;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDto){
        LoginResponse loginMessage=userService.loginUser(loginDto);
        return  ResponseEntity.ok(loginMessage);
    }
}
