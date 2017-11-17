package com.mars.dao;

import com.mars.model.Girl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GirlDao {
    List<Girl> list();
}
