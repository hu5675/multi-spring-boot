package com.mars.service.impl;

import com.mars.dao.cluster.CityDao;
import com.mars.dao.master.UserDao;
import com.mars.model.City;
import com.mars.model.User;
import com.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    CityDao cityDao;

    @Override
    public User findByName(String userName) {
        User user = this.userDao.findByName(userName);
        City city = this.cityDao.findByName("温岭市");
        user.setCity(city);
        return  user;
    }
}
