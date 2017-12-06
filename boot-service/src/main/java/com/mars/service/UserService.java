package com.mars.service;

import com.mars.exception.GlobalException;
import com.mars.model.User;

public interface UserService {
    User findByName(String userName);

    void  inserUser(User user) throws GlobalException;
}
