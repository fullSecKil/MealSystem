package com.meal.vortex.repository.tools;

import com.meal.vortex.repository.mapper.UserMapper;
import com.meal.vortex.repository.mealmapper.MealMapper;
import com.meal.vortex.repository.recordmapper.RecordMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperComponent {

    @Autowired DBTools dbTools;

    public SqlSession session=dbTools.getSession();

    public UserMapper userMapper=session.getMapper(UserMapper.class);

    public MealMapper mealMapper=session.getMapper(MealMapper.class);

    public RecordMapper recordMapper=session.getMapper(RecordMapper.class);

    public void commit(){
        session.commit();
    }
}
