package com.nyu.db.projServer.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.nyu.db.projServer.DTO.Response.EmailCode;
import com.nyu.db.projServer.DTO.Response.UserLoginDto;
import com.nyu.db.projServer.DTO.Response.UserRegisterDto;
import com.nyu.db.projServer.DTO.Response.UserResetDto;
import com.nyu.db.projServer.DTO.Response.vo.UserLoginVo;
import com.nyu.db.projServer.mapper.AddressMapper;
import com.nyu.db.projServer.mapper.CorporationMapper;
import com.nyu.db.projServer.mapper.CustomerMapper;
import com.nyu.db.projServer.model.Address;
import com.nyu.db.projServer.model.Corporation;
import com.nyu.db.projServer.model.Customer;
import com.nyu.db.projServer.service.EmailService;
import com.nyu.db.projServer.service.ICustomerService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    private static Map<String, EmailCode> emailCodeMap = new HashMap<>();

    private Lock lock = new ReentrantLock();

    private static Map<String, EmailCode> resetEmailCodeMap = new HashMap<>();

    private Lock resetLock = new ReentrantLock();

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public UserLoginVo login(UserLoginDto dto) {
        Customer customer = customerMapper.getByUserName(dto.getUsername(),dto.getUserType());
        Assert.isTrue(customer!=null,"Username does not exist");
        Assert.isTrue(customer.getPassword().equals(SecureUtil.md5().digestHex(dto.getPassword())),"Incorrect Password");
        UserLoginVo vo = new UserLoginVo();
        String token = Base64.getEncoder().encodeToString(JSON.toJSONString(customer).getBytes());
        vo.setToken(token);
        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterDto dto) {
        Customer customer = customerMapper.getByUserName(dto.getUsername(),dto.getUserType());
        Assert.isTrue(customer == null,"Username already exists.");
        Customer byEmail = customerMapper.getByEmail(dto.getEmail());
        Assert.isTrue(byEmail == null,"Email already exists.");

        // verification code
        lock.lock();
        try {
            EmailCode s = emailCodeMap.get(dto.getEmail());
            Assert.isTrue(ObjectUtil.isNotNull(s),"Please send verification code.");
            Assert.isTrue(s.getExpirationTime() >= System.currentTimeMillis(),"Verification code has expired.");
            Assert.isTrue(s.getCode().equals(dto.getCode()),"Verification code is wrong.");
        }finally {
            lock.unlock();
        }
        customer = new Customer();
        customer.setCustomerType(dto.getUserType());
        customer.setPhone(dto.getPhone());
        Address address = new Address();
        address.setCity(dto.getAddressCity());
        address.setState(dto.getAddressState());
        address.setStreet(dto.getAddressStreet());
        address.setZipCode(dto.getAddressZipCode());
        addressMapper.insert(address);
        customer.setAddressId(address.getAddressID());
        customer.setEmail(dto.getEmail());
        customer.setPassword(SecureUtil.md5().digestHex(dto.getPassword()));
        customer.setUsername(dto.getUsername());
        String registName = dto.getRegistName();
        if (StringUtils.isNotBlank(registName)) {
            Corporation corporation = new Corporation();
            corporation.setRegistNo(IdUtil.fastSimpleUUID());
            corporation.setName(registName);
            corporationMapper.insert(corporation);
        }
        customerMapper.insert(customer);
    }

    @Autowired
    private EmailService emailService;

    @Override
    public void sendMsg(String email) {
        Customer byEmail = customerMapper.getByEmail(email);
        Assert.isTrue(byEmail == null,"Email already exists.");
        lock.lock();
        try {
            String code = generateCode();
            //5 minutes to expire
            EmailCode emailCode = new EmailCode(code, System.currentTimeMillis() + 5 * 60 * 1000);
            System.err.println("Register an account: {"+email+"}  --  {"+code+"}");
            emailCodeMap.put(email,emailCode);
            emailService.sendVerificationCode(email,code);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void resetSendMsg(String email) {
        Customer byEmail = customerMapper.getByEmail(email);
        Assert.isTrue(byEmail != null,"Email does not exist.");
        resetLock.lock();
        try {
            String code = generateCode();
            //5 minutes to expire
            EmailCode emailCode = new EmailCode(code, System.currentTimeMillis() + 5 * 60 * 1000);
            System.err.println("Reset password: {"+email+"}  --  {"+code+"}");
            resetEmailCodeMap.put(email,emailCode);
            emailService.sendVerificationCode(email,code);
        }finally {
            resetLock.unlock();
        }
    }

    @Override
    public void reset(UserResetDto dto) {
        resetLock.lock();
        try {
            EmailCode emailCode = resetEmailCodeMap.get(dto.getEmail());
            Assert.isTrue(ObjectUtil.isNotNull(emailCode),"Please send verification code.");
            Assert.isTrue(emailCode.getExpirationTime() >= System.currentTimeMillis(),"Verification code has expired.");
            Assert.isTrue(emailCode.getCode().equals(dto.getCode()),"Verification code is wrong.");
        }finally {
            resetLock.unlock();
        }
        Customer byEmail = customerMapper.getByEmail(dto.getEmail());
        byEmail.setPassword(SecureUtil.md5().digestHex(dto.getNewPassword()));
        customerMapper.updatePassword(byEmail);
    }

    private static String generateCode() {
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            // Generate random numbers between 0 and 9
            int number = random.nextInt(10);
            code += String.valueOf(number);
        }
        return code;
    }
}
