package com.mars.dao.cluster;

import com.mars.model.City;
import org.apache.ibatis.annotations.Param;

public interface CityDao {

    City findByName(@Param("cityName") String cityName);

    City findById(@Param("id") Long id);

    void insertCity(@Param("city") City city);

    void deleteCityById(@Param("id") Long id);
}
