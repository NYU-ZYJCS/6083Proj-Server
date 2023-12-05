package com.nyu.db.projServer.model;

public class VehicleClass {
    private Long classID;
    private String type;
    private Double dailyRate;
    private Double overMileFee;

public VehicleClass() {

    }

    public VehicleClass(Long classID, String type, Double dailyRate, Double overMileFee) {
        this.classID = classID;
        this.type = type;
        this.dailyRate = dailyRate;
        this.overMileFee = overMileFee;
    }

    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Double getOverMileFee() {
        return overMileFee;
    }

    public void setOverMileFee(Double overMileFee) {
        this.overMileFee = overMileFee;
    }
}
