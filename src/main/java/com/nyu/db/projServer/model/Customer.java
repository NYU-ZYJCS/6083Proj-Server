package com.nyu.db.projServer.model;

import java.io.Serializable;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * address_id
     */
    private Long addressId;

    /**
     * customer id
     */
    private Integer customerId;

    /**
     * email address
     */
    private String email;

    /**
     * User Name
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * phone number
     */
    private String phone;

    /**
     * customer type
     */
    private String customerType;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer() {}

}