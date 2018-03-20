package com.mars.controller;

import com.mars.mongo.UserEntity;
import com.mars.service.UserMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping
public class MongoController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    UserMongoService userMongoService;

    @GetMapping(value = "/mongo/save")
    public UserEntity save(HttpServletRequest request) throws IOException {
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userMongoService.saveUser(user);
        return  user;
    }

    @GetMapping(value = "/mongo/find")
    public UserEntity find(HttpServletRequest request) throws IOException {
        UserEntity user = userMongoService.findUserByUserName("小明");
        return  user;
    }

    @GetMapping(value = "/mongo/update")
    public UserEntity update(HttpServletRequest request) throws IOException {
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userMongoService.updateUser(user);
        return  user;
    }

    @GetMapping(value = "/mongo/delete")
    public UserEntity delete(HttpServletRequest request) throws IOException {
        userMongoService.deleteUserById(2l);
        return new UserEntity();
    }
}
