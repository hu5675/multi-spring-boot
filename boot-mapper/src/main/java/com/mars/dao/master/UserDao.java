package com.mars.dao.master;

import com.mars.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User findByName(@Param("userName") String userName);
}
