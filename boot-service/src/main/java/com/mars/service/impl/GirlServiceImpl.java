package com.mars.service.impl;

import com.mars.dao.GirlDao;
import com.mars.model.Girl;
import com.mars.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlServiceImpl implements GirlService{

    @Autowired
    public GirlDao girlDao;

    @Override
    public List<Girl> list() {
        return  girlDao.list();
    }
}
