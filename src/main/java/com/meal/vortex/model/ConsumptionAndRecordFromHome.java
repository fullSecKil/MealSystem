package com.meal.vortex.model;

import com.meal.vortex.repository.beans.RecordBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsumptionAndRecordFromHome {

    private long record;

    private Double today_Consumption;

    private Double ever_Consumption;

    private long mealQuantity;

    private List<RecordBean> recordRow;

    public ConsumptionAndRecordFromHome(){

    }

    public ConsumptionAndRecordFromHome(long record, Double ever_Consumption, Double today_Consumption, long mealQuantity, List<RecordBean> recordRow){
        this.record = record;
        this.today_Consumption = today_Consumption;
        this.ever_Consumption = ever_Consumption;
        this.mealQuantity = mealQuantity;
        this.recordRow = recordRow;
    }

    public void setRecord(long record) {
        this.record = record;
    }

    public long getRecord() {
        return record;
    }

    public Double getToday_Consumption() {
        return today_Consumption;
    }

    public void setToday_Consumption(Double today_Consumption) {
        this.today_Consumption = today_Consumption;
    }

    public Double getEver_Consumption() {
        return ever_Consumption;
    }

    public void setEver_Consumption(Double ever_Consumption) {
        this.ever_Consumption = ever_Consumption;
    }

    public long getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(long mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public List<RecordBean> getRecordRow() {
        return recordRow;
    }

    public void setRecordRow(List<RecordBean> recordRow) {
        this.recordRow = recordRow;
    }
}
