package com.nyu.db.projServer.DTO.Response;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
public class UserLoginDto {

    private String username;

    private String password;

    private String userType;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserLoginDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userType='").append(userType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
