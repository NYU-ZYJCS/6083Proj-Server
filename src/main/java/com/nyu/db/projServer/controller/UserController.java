package com.nyu.db.projServer.controller;

import com.nyu.db.projServer.DTO.Response.UserLoginDto;
import com.nyu.db.projServer.DTO.Response.UserRegisterDto;
import com.nyu.db.projServer.DTO.Response.UserResetDto;
import com.nyu.db.projServer.DTO.Response.vo.UserLoginVo;
import com.nyu.db.projServer.service.ICustomerService;
import com.nyu.db.projServer.utils.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin(origins = "http://localhost:3000") // Allow this origin
public class UserController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponses<UserLoginVo>> login(@RequestBody UserLoginDto dto){
        UserLoginVo vo = customerService.login(dto);
        return ResponseEntity.ok(new ApiResponses(vo,"succeed",200,true));
    }

    @GetMapping("/sendMsg")
    public ResponseEntity<ApiResponses> sendMsg(@RequestParam("email")String email){
        customerService.sendMsg(email);
        return ResponseEntity.ok(new ApiResponses(null,"succeed",200,true));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponses> register(@RequestBody UserRegisterDto dto){
        customerService.register(dto);
        return ResponseEntity.ok(new ApiResponses(null,"succeed",200,true));
    }

    @PostMapping("/reset")
    public ResponseEntity<ApiResponses> reset(@RequestBody UserResetDto dto){
        customerService.reset(dto);
        return ResponseEntity.ok(new ApiResponses(null,"succeed",200,true));
    }

    @GetMapping("/reset/sendMsg")
    public ResponseEntity<ApiResponses> resetSendMsg(@RequestParam("email")String email){
        customerService.resetSendMsg(email);
        return ResponseEntity.ok(new ApiResponses(null,"succeed",200,true));
    }

}
