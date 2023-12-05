package com.nyu.db.projServer.model;


public class Vehicle {
    private Long vehicleID;
    private String make;
    private String imgUrl;

    private String model;

    private Long officeID;
    private Long vehicleClassID;

    private int year;

    private VehicleClass vehicleClass;

    public Vehicle() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    public Long getVehicleClassID() {
        return vehicleClassID;
    }

    public void setVehicleClassID(Long vehicleClassID) {
        this.vehicleClassID = vehicleClassID;
    }
}
