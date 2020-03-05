package com.example.demo.controller;

import com.example.demo.corecard.model.Bank;
import com.example.demo.corecard.repo.BankRepository;
import com.example.demo.merchantrefund.repo.UserRepository;
import com.example.demo.servicegateway.model.Channel;
import com.example.demo.servicegateway.repo.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChannelRepository channelRepository;

    @RequestMapping("/test")
    public List<Channel> test(){
        return channelRepository.findAll();
    }
 }
