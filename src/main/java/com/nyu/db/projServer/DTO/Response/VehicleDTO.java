package com.nyu.db.projServer.DTO.Response;

import java.math.BigDecimal;

public class VehicleDTO {
    private Long vehicleID;
    private String make;
    private String model;
    private Double dailyRate;
    private Double overMileFee;

    private int year;
    private String imgUrl;

    public VehicleDTO() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
