package com.mars.dao;

import com.mars.model.Girl;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GirlDao {
    @Select("select * from girl")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "age",property = "age"),
            @Result(column = "cup_size",property = "cupSize"),
            @Result(column = "money",property = "money")
    })
    List<Girl> list();
}
