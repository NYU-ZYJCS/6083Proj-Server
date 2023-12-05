package com.nyu.db.projServer.mapping;


import com.nyu.db.projServer.DTO.Response.VehicleDTO;
import com.nyu.db.projServer.model.Vehicle;

public class VehicleDTOMapping {
    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVehicleID(vehicle.getVehicleID());
        vehicleDTO.setMake(vehicle.getMake());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setYear(vehicle.getYear());
        vehicleDTO.setImgUrl(vehicle.getImgUrl());
        vehicleDTO.setDailyRate(vehicle.getVehicleClass().getDailyRate());
        vehicleDTO.setOverMileFee(vehicle.getVehicleClass().getOverMileFee());
        return vehicleDTO;
    }

}
