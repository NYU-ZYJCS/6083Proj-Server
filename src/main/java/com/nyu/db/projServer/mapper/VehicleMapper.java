package com.nyu.db.projServer.mapper;

import com.nyu.db.projServer.model.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface VehicleMapper {
    List<Vehicle> getVehicleByOfficeID(Long officeID);
}
