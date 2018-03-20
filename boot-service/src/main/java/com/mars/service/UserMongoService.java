package com.mars.service;

import com.mars.mongo.UserEntity;

public interface UserMongoService {
    
    void saveUser(UserEntity user);

    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity user);

    void deleteUserById(Long id);
}
