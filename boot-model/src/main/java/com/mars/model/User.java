package com.mars.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


public class User {
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */

    @NotNull(message = "名称不能为空")
    @Length(message = "长度必须大于4",min = 4)
    private String userName;

    /**
     * 描述
     */
    private String description;

    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
