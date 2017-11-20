package com.mars.controller;

import com.mars.model.User;
import com.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/api/user")
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }
}
