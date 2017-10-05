package com.meal.vortex.repository.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserBean implements Serializable {
    private static final long serialVersionUID =1L;
    private Integer id;
    private String username;
    private String age;
    private String password;
    private String image;

    public UserBean(){
        super();
    }

    public UserBean(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    public UserBean(String username, String age, String password){
        super();
        this.username = username;
        this.age = age;
        this.password = password;
    }
    public UserBean(String username, String age, String password, String image) {
        super();
        this.username = username;
        this.age = age;
        this.password = password;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username +",age" + age + ", password="
                + password  +"]";
    }
}
