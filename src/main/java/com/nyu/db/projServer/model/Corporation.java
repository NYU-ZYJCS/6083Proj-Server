package com.nyu.db.projServer.model;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
public class Corporation {

    /**
     * Registration Number
     */
    private String registNo;

    /**
     * Corporation Name
     */
    private String name;

    public Corporation() {}

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
