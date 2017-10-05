package com.meal.vortex.repository;

import com.meal.vortex.repository.beans.MealBean;
import com.meal.vortex.repository.beans.RecordBean;
import com.meal.vortex.repository.beans.UserBean;
import com.meal.vortex.repository.mapper.UserMapper;
import com.meal.vortex.repository.mealmapper.MealMapper;
import com.meal.vortex.repository.recordmapper.RecordMapper;
import com.meal.vortex.repository.tools.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UserServiceTest {
    @Test
    public void selectAllUser() throws Exception {
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            UserBean user=mapper.selectUserById(1);
            System.out.println(user.toString());
            session.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

   @Test
    public void selectAllMeal() throws Exception{
        SqlSession session=DBTools.getSession();
        MealMapper mapper=session.getMapper(MealMapper.class);
        try {
            MealBean meal = mapper.selectMealById(4);
            System.out.println(meal.toString());
            session.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
   }

   @Test
    public void insertMeal() throws Exception{
       SqlSession session = DBTools.getSession();
       MealMapper mapper = session.getMapper(MealMapper.class);
       UserMapper mapper2=session.getMapper(UserMapper.class);
        try{
            UserBean user = mapper2.selectUserById(1);
            int meal = mapper.insertMeal(new MealBean(33.3,user));
            System.out.println(mapper.selectAllMeal().toString());
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
   }

    @Test
    public void insertRecord() throws Exception{
        SqlSession session=DBTools.getSession();
        RecordMapper mapper = session.getMapper(RecordMapper.class);
        MealMapper mapper2=session.getMapper(MealMapper.class);

        try{

            int i = mapper.insertRecord(new RecordBean(55.5,"xuerui",mapper2.selectMealById(3)));
            List<RecordBean> record = mapper.selectAllRecord();
            System.out.println(record);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

    }
}
