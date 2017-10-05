package com.meal.vortex.repository.tools;

import com.meal.vortex.repository.beans.MealBean;
import com.meal.vortex.repository.beans.RecordBean;
import com.meal.vortex.repository.beans.UserBean;
import org.springframework.stereotype.Component;

@Component
public class BeansComponent {

    public MealBean getMealBean() {
        return new MealBean();
    }

    public UserBean getUserBean() {
        return new UserBean();
    }

    public RecordBean getRecordBean() {
        return new RecordBean();
    }
}
