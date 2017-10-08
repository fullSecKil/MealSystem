package com.meal.vortex.controller;

import com.meal.vortex.config.DataConfig;
import com.meal.vortex.repository.beans.UserBean;
import com.meal.vortex.repository.tools.MapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ColltrollerMain {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(){
        return "home";
    }
    @Autowired
    MapperComponent mapperComponent;
    @RequestMapping("/abc")
    @ResponseBody
    public String showAbc() throws Exception {
        System.out.println("showAbc");
        System.out.println(mapperComponent.userMapper.selectUserByName("xuerui"));
        return "xuerui";
    }
}
