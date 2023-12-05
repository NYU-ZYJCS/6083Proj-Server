package com.nyu.db.projServer.DTO.Response;

public class OfficeDTO {
    private Long officeID;
    private String phone;
    private AddressDTO address;

    public OfficeDTO() {

    }

    public Long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
