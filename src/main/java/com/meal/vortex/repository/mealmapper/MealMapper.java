package com.meal.vortex.repository.mealmapper;

import com.meal.vortex.repository.beans.MealBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MealMapper {
    public int insertMeal(MealBean mealBean) throws Exception;

    public int updateMeal(MealBean mealBean) throws Exception;

    public int deleteMeal(int meal_id) throws Exception;

    public MealBean selectMealById(int meal_id) throws Exception;

    public List<MealBean> selectMealByUserName(String userName) throws Exception;

    public List<MealBean> selectAllMeal() throws Exception;
}