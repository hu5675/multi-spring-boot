package com.mars.service.impl;

import com.mars.dao.cluster.CityDao;
import com.mars.dao.master.UserDao;
import com.mars.enums.ResultEnum;
import com.mars.exception.GlobalException;
import com.mars.model.City;
import com.mars.model.User;
import com.mars.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


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

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3600,rollbackFor = Exception.class)
    public void inserUser(User user) throws GlobalException {
        this.userDao.insertUser(user);
        logger.info("插入成功-----------");
        logger.info("抛异常看事务能回滚不");
        throw new GlobalException(ResultEnum.UNKONW_ERROR);
    }


}
