package com.meal.vortex.repository.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class MealBean  implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer meal_id;
    private Double balance;
    private Timestamp found_datetime;

    private UserBean userBean;

    public MealBean(){}

    public MealBean(Double balance, UserBean userBean){
        this.balance = balance;
        this.userBean = userBean;
    }

    public Integer getId() {
        return meal_id;
    }

    public void setId(Integer meal_id) {
        this.meal_id = meal_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getFound_datetime() {
        return found_datetime;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    public String toString() {
        return "MealBean [meal_id=" + meal_id + ", balance=" + balance + ", found_datetime=" + found_datetime + ", userBean=" + userBean + "]";
    }
}
