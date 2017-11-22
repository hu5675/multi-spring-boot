package com.mars.service.impl;

import com.mars.dao.cluster.CityDao;
import com.mars.model.City;
import com.mars.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements CityService{

    private static  final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    CityDao cityDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public City findCityById(Long id) {
        String key = "city_" + id;
        ValueOperations<String,City> operations = this.redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return  city;
        }

        City city =  this.cityDao.findById(id);
        try {
            operations.set(key,city);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }

        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
        return  city;
    }

    @Cacheable(value = "city" ,key = "'city_'+#id")
    public City findCityByCityId(Long id){
        return this.cityDao.findById(id);
    }

    @CachePut(cacheNames = "city",key = "'city_'+#city.id")
    public City insertCity(City city){
        this.cityDao.insertCity(city);
        LOGGER.info("CityServiceImpl.insertCity(): 返回结果 >> " + city);
        return city;
    }

    @CacheEvict(cacheNames = "city",key = "'city_'+#id")
    public void deleteCity(Long id){
        this.cityDao.deleteCityById(id);
    }
}
