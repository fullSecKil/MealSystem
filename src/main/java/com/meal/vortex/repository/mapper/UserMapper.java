package com.meal.vortex.repository.mapper;

import com.meal.vortex.repository.beans.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper  {
    //新增用户
    public int inserUser(UserBean userBean) throws Exception;

    //更新用户
    public int updateUser(UserBean userBean) throws Exception;

    //删除用户
    public int deleteUser(int id) throws Exception;

    //根据id查询
    public UserBean selectUserById(int id) throws Exception;

    //查询所有用户
    public List<UserBean> selectAllUser() throws Exception;
}
