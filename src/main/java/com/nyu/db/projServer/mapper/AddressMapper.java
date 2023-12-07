package com.nyu.db.projServer.mapper;

//import org.apache.ibatis.annotations.Mapper;

import com.nyu.db.projServer.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {

    /**
     * 新增
     * @author BEJSON
     * @date 2023/12/07
     **/
    int insert(Address address);

}
