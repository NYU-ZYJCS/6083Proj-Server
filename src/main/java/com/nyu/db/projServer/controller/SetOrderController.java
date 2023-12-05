package com.nyu.db.projServer.controller;

import com.nyu.db.projServer.DTO.Response.OfficeDTO;
import com.nyu.db.projServer.DTO.Response.VehicleDTO;
import com.nyu.db.projServer.model.Vehicle;
import com.nyu.db.projServer.service.OrderService;
import com.nyu.db.projServer.utils.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nyu.db.projServer.model.Office;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/set-order")
@CrossOrigin(origins = "http://localhost:3000") // Allow this origin
public class SetOrderController {
    private final OrderService setOrderService;


    @Autowired
    public SetOrderController(OrderService setOrderService) {
        this.setOrderService = setOrderService;
    }

    @GetMapping("/office-list")
    public ResponseEntity<ApiResponses<List<OfficeDTO>>> getOfficeList() {
        ApiResponses<List<OfficeDTO>> response = new ApiResponses<>(setOrderService.getOfficeList(), "success",
                200, true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/vehicle/search")
    public ResponseEntity<ApiResponses<List<VehicleDTO>>> getVehicleByOfficeID(@RequestParam("officeID") Long officeID) {
        ApiResponses<List<VehicleDTO>> response = new ApiResponses<>(setOrderService.getVehicleByOfficeID(officeID),
                "success", 200, true);
        return ResponseEntity.ok(response);
    }
}




