package com.mars.dao.cluster;

import com.mars.model.City;
import org.apache.ibatis.annotations.Param;

public interface CityDao {

    City findByName(@Param("cityName") String cityName);

    City findById(@Param("id") Long id);
}
