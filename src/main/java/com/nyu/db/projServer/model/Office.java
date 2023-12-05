package com.nyu.db.projServer.model;


public class Office {

    private Long officeID;
    private String phone;
    private int addressID;

    private Address address;

    public Office() {

    }

    public Office (Long officeID, String phone, int addressID) {
        this.officeID = officeID;
        this.phone = phone;
        this.addressID = addressID;
    }

    public Office (String phone, int addressID) {
        this.phone = phone;
        this.addressID = addressID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
