package com.nyu.db.projServer.mapper;

import com.nyu.db.projServer.model.Office;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfficeMapper {

    public Office getOfficeByIDWithAddress(Long officeID);

    public List<Office> getAllOfficesWithAddress();
}
