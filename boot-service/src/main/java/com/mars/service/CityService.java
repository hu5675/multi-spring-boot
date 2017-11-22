package com.mars.service;

import com.mars.model.City;
import org.springframework.cache.annotation.Cacheable;

public interface CityService {
    public City findCityById(Long id);

    public City findCityByCityId(Long id);

    public City insertCity(City city);

    public void deleteCity(Long id);
}
