package com.meal.vortex.controller;

import com.meal.vortex.model.ConsumptionAndRecordFromHome;
import com.meal.vortex.model.LoginUser;
import com.meal.vortex.repository.beans.MealBean;
import com.meal.vortex.repository.beans.RecordBean;
import com.meal.vortex.repository.beans.UserBean;
import com.meal.vortex.repository.tools.BeansComponent;
import com.meal.vortex.repository.tools.MapperComponent;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

@Controller
@SessionAttributes(value={"loginUser"})
@RequestMapping("/form")
public class ControllerFromForm {

    @Autowired
    MapperComponent mapperComponent;

    @Autowired
    BeansComponent beansComponent;

    @Autowired
    LoginUser loginUser;

    //登录映射器

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin(Model model){
        model.addAttribute("loginUser",loginUser);
        return "/login";
    }
    /* @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     public String userLoginJudge(@ModelAttribute("loginUser" ) LoginUser loginUser){
         return "/admin-index";
     }
 */
    //登录验证

    @RequestMapping(value = "/user/login")
    public String userLoginJudge(@ModelAttribute() final LoginUser loginUser, ModelMap modelMap) throws Exception {
        //mapperComponent.commit();

        List<UserBean> user = mapperComponent.userMapper.selectAllUser();

        Optional<UserBean> userBeanOption = user.stream().filter(u->u.getUsername().equals(loginUser.getUserName())&&u.getPassword().equals(loginUser.getPassword())).findAny();
        Timestamp ts = Timestamp.valueOf(DateFormatUtils.format(new Timestamp(System.currentTimeMillis()), "yyyy-MM-dd 00:00:00"));     //今日0点
        Map<String,Double> contents = new HashMap<>();


        if(userBeanOption.isPresent()) {
            modelMap.addAttribute("userBean",userBeanOption);
            List<RecordBean> record = mapperComponent.recordMapper.selectAllRecord();

            //Map<String,List<RecordBean>>
            record.stream().collect(Collectors.groupingBy(RecordBean::getCountent)).forEach((k,v)->contents.put(k,v.stream().mapToDouble(RecordBean::getConsume).sum()));        //分组求和
            //group.forEach((k,v)->contents.put(k,v.stream().map(RecordBean::getConsume).reduce(0.0,Double::sum)));         // 求和
            if( ! contents.isEmpty()){
                modelMap.addAttribute("contents",contents);
            }
            modelMap.addAttribute("consumption",new ConsumptionAndRecordFromHome(record.stream().count(),record.stream().mapToDouble(RecordBean::getConsume).sum(),record.stream().filter(d->d.getConsume_datetime().after(ts)).mapToDouble(RecordBean::getConsume).sum(),record.stream().filter(r->r.getMealBean()!=null).map(RecordBean::getMealBean).map(MealBean::getId).distinct().count(),record.stream().sorted(Comparator.comparing(RecordBean::getRecord_id).reversed()).collect(toList())));
            return "/admin-index";
        }
        return "/admin-404";
    }

    //登出
    @RequestMapping(value = "/user/signout")
    public String userSignOut(SessionStatus status){
        status.setComplete();
        return "redirect:/form/login";
    }

    //删除消费记录
    @RequestMapping(value = "/record/delete/{record_id}")
    public String delectRecord(@PathVariable("record_id") Integer record_id) throws Exception {
        mapperComponent.recordMapper.deleteRecord(record_id);
        mapperComponent.commit();
        return "redirect:/form/user/login";
    }

    //添加饭卡
    @RequestMapping(value = "/meal/add")
    public String addMeal(ModelMap modelMap) throws Exception {
        List<UserBean> user = mapperComponent.userMapper.selectAllUser();
        modelMap.addAttribute("userList",user);
        modelMap.addAttribute(beansComponent.getMealBean());
        return "/add-meal";
    }

    @RequestMapping(value = "/meal/addP", method = RequestMethod.POST)
    public String addMealPost(@ModelAttribute() MealBean mealBean) throws Exception {
        mapperComponent.mealMapper.insertMeal(mealBean);
        mapperComponent.commit();
        return "redirect:/form/meal/show";
    }

    //显示饭卡用户
    @RequestMapping(value = "/meal/show")
    public String showMeals(ModelMap modelMap) throws Exception {
        List<MealBean> meals= mapperComponent.mealMapper.selectAllMeal().stream().sorted(Comparator.comparing(MealBean::getId).reversed()).collect(toList());
        modelMap.addAttribute(meals);

        return "/show-meal";
    }

    @RequestMapping(value = "/meal/show/filter/{userName}")
    public String showMeals(@PathVariable("userName") String userName,  ModelMap modelMap) throws Exception {
        if(userName.isEmpty()){
            return "redirect:/form/meal/show";
        }
        //List<MealBean> meals= mapperComponent.mealMapper.selectAllMeal().stream().filter(d->d.getUserBean().getUsername().contains(userName)).sorted(Comparator.comparing(MealBean::getId).reversed()).collect(toList());

        List<MealBean> meals = mapperComponent.mealMapper.selectMealByUserName(userName);

        modelMap.addAttribute(meals);
        return "/show-meal";
    }

    //显示用户详细信息
    @RequestMapping(value = "/user/show/{id}")
    public String showUser(@PathVariable("id") Integer userId, Model model) throws Exception {
        UserBean user = mapperComponent.userMapper.selectUserById(userId);
        model.addAttribute(user);
        return "/show-user";
    }

    //更新meal
    @RequestMapping(value = "/meal/update/{id}")
    public String updateMeal(@PathVariable("id") Integer mealId, Model model) throws Exception {
        MealBean meal = mapperComponent.mealMapper.selectMealById(mealId);
        List<UserBean> users = mapperComponent.userMapper.selectAllUser();
        model.addAttribute(users);
        model.addAttribute(meal);
        return "/update-meal";
    }

    @RequestMapping(value = "/meal/updateP", method = RequestMethod.POST)
    public String updateMealPost(@ModelAttribute("mealP") MealBean mealBean) throws Exception {
        mapperComponent.mealMapper.updateMeal(mealBean);
        mapperComponent.commit();

        return "redirect:/form/meal/show";
    }

    //删除meal
    @RequestMapping(value = "/meal/delete/{id}")
    public String deleteMeal(@PathVariable("id") Integer userId) throws Exception {
        mapperComponent.mealMapper.deleteMeal(userId);
        mapperComponent.commit();

        return "redirect:/form/meal/show";
    }

    //饭卡消费
    @RequestMapping(value="/meal/consume", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doConsume(String meal_id, String consume, HttpServletResponse response, HttpServletRequest request) {
        String result = "fail";
        String context = "卡号不存在，失败！";
        Map<String, Object> reault = new HashMap<>();

        MealBean meal = null;
        try {
            meal = mapperComponent.mealMapper.selectMealById(Integer.parseInt(meal_id));
        } catch (Exception e) {
            e.printStackTrace();
            reault.put("result",result);
            reault.put("context",context);
            return reault;
        }
        if(meal == null){
                reault.put("result",result);
                reault.put("context",context);
                return reault;
            }
            if(meal.getBalance()-Double.parseDouble(consume)<0){
                context = "余额不足请充值！";
                reault.put("result",result);
                reault.put("context",context);
                return reault;
            }
            meal.setBalance(meal.getBalance()-Double.parseDouble(consume));
        try {
                mapperComponent.mealMapper.updateMeal(meal);
            }
            catch (Exception e) {
                e.printStackTrace();
                context = "支付失败！";
                reault.put("result",result);
                reault.put("context",context);
                return reault;
            }
        result = "success";
        context= consume+"元支付成功";
        reault.put("result",result);
        reault.put("context",context);
        return reault;
    }
    //饭卡充值

}
