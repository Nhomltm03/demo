package com.example.demo.controller;

import com.example.demo.bussiness.UserBusiness;
import com.example.demo.model.UserInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBusiness mBusiness;

    @GetMapping("")
    public ResponseEntity<UserInformation> getInfor() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(mBusiness.getUserInformation());
    }
}