package com.mars.controller;

import com.mars.enums.ResultEnum;
import com.mars.exception.GlobalException;
import com.mars.model.User;
import com.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/api/user")
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }

    @PostMapping(value = "/api/user")
    public void userAdd(@Valid User user, BindingResult bindingResult) throws GlobalException {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError("userName").getDefaultMessage());
            throw new GlobalException(ResultEnum.UNKONW_ERROR);
        }
        this.userService.inserUser(user);
    }

}
