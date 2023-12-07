package com.nyu.db.projServer.mapper;

import com.nyu.db.projServer.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
@Mapper
public interface CustomerMapper  {

    Customer getByUserName(@Param("username") String username,@Param("userType") String userType);

    Customer getByEmail(@Param("email") String email);

    void insert(Customer customer);

    void updatePassword(Customer customer);

}