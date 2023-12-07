package com.nyu.db.projServer.mapper;

import com.nyu.db.projServer.model.Corporation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
@Mapper
public interface CorporationMapper {

    void insert(Corporation corporation);

}
