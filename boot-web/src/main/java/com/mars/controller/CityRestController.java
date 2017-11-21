package com.mars.controller;

import com.mars.model.City;
import com.mars.model.User;
import com.mars.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/api/city/{id}")
    public City findByName(@PathVariable(value = "id") Long id) {
        return cityService.findCityById(id);
    }
}
