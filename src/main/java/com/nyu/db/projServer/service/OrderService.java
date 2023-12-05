package com.nyu.db.projServer.service;

import com.nyu.db.projServer.DTO.Response.VehicleDTO;
import com.nyu.db.projServer.mapper.OfficeMapper;
import com.nyu.db.projServer.mapper.VehicleMapper;
import com.nyu.db.projServer.mapping.VehicleDTOMapping;
import com.nyu.db.projServer.model.Office;
import com.nyu.db.projServer.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class OrderService {
    private final VehicleMapper vehicleMapper;
    private final OfficeMapper officeMapper;
    @Autowired
    public OrderService(VehicleMapper vehicleMapper, OfficeMapper officeMapper) {
        this.vehicleMapper = vehicleMapper;
        this.officeMapper = officeMapper;
    }



    public List<VehicleDTO> getVehicleByOfficeID(Long officeID) {
         return vehicleMapper.getVehicleByOfficeID(officeID).stream().parallel()
                 .map(VehicleDTOMapping::toVehicleDTO).collect(Collectors.toList());
    }

    public List<Office> getOfficeList() {
        return officeMapper.getAllOfficesWithAddress();
    }
}
