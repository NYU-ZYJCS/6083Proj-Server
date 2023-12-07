package com.nyu.db.projServer.service;

import com.nyu.db.projServer.DTO.Response.UserLoginDto;
import com.nyu.db.projServer.DTO.Response.UserRegisterDto;
import com.nyu.db.projServer.DTO.Response.UserResetDto;
import com.nyu.db.projServer.DTO.Response.vo.UserLoginVo;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
public interface ICustomerService {

    /**
     * login
     * @param dto
     * @return
     */
    UserLoginVo login(UserLoginDto dto);

    /**
     * register
     * @param dto
     */
    void register(UserRegisterDto dto);

    /**
     * Send Verification Code
     * @param email
     */
    void sendMsg(String email);

    /**
     * reset Verification Code
     * @param email
     */
    void resetSendMsg(String email);

    /**
     * Reset password
     * @param dto
     */
    void reset(UserResetDto dto);
}
