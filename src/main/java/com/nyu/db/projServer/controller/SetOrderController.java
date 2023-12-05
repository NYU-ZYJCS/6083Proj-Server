package com.nyu.db.projServer.controller;

import com.nyu.db.projServer.DTO.Response.VehicleDTO;
import com.nyu.db.projServer.model.Vehicle;
import com.nyu.db.projServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nyu.db.projServer.model.Office;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/set-order")

public class SetOrderController {
    private final OrderService setOrderService;


    @Autowired
    public SetOrderController(OrderService setOrderService) {
        this.setOrderService = setOrderService;
    }

    @GetMapping("/office-list")
    public List<Office> getOfficeList() {
        return setOrderService.getOfficeList();
    }

    @PostMapping("/vehicle/search")
    public List<VehicleDTO> getVehicleByOfficeID(@RequestParam("officeID") Long officeID) {
        return setOrderService.getVehicleByOfficeID(officeID);
    }
}




