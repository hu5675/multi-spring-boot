package com.mars.controller;

import com.mars.model.City;
import com.mars.model.User;
import com.mars.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityRestController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/api/city/{id}")
    public City findCityById(@PathVariable(value = "id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping(value = "/api/v2/city/{id}")
    public City  findCityByCityId(@PathVariable(value = "id") Long id) {
        return cityService.findCityByCityId(id);
    }

    @PostMapping(value = "/api/v2/city")
    public void insertCity(@RequestBody City city) {
        cityService.insertCity(city);
    }

    @DeleteMapping(value = "api/v2/city/{id}")
    public void  deleteCity(@PathVariable(value = "id") Long id){
        cityService.deleteCity(id);
    }

}
