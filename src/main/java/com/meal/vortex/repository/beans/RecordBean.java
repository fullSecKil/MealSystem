package com.meal.vortex.repository.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class RecordBean  implements Serializable {
    private static final long serialVersionUID =3L;
    private Integer record_id;
    private Double consume;
    private String content;
    private Timestamp consume_datetime;
    private MealBean mealBean;

    public RecordBean(){ }

    public RecordBean(Double consume, String content, MealBean mealBean){
        this.consume = consume;
        this.content = content;
        this.mealBean = mealBean;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Double getConsume() {
        return consume;
    }

    public void setConsume(Double consume) {
        this.consume = consume;
    }

    public String getCountent() {
        return content;
    }

    public void setCountent(String countent) {
        this.content = countent;
    }

    public Timestamp getConsume_datetime() {
        return consume_datetime;
    }

    public void setConsume_datetime(Timestamp consume_datetime) {
        this.consume_datetime = consume_datetime;
    }

    public MealBean getMealBean() {
        return mealBean;
    }

    public void setMealBean(MealBean mealBean) {
        this.mealBean = mealBean;
    }

    @Override
    public String toString() {
        return "RecordBean [record_id=" + record_id + ", consume=" + consume + ", content=" + content + ", consume_datetime=" + consume_datetime +  ", mealBean=" + mealBean + "]";
    }
}
