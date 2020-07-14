package com.example.demo.controller;

import java.util.Map;

import com.example.demo.bussiness.UserBusiness;
import com.example.demo.model.UserInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBusiness mBusiness;

    @GetMapping("/get")
    public ResponseEntity<UserInformation> getInfor() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(this.mBusiness.getUserInformation());
    }

    @PostMapping("/post")
    public ResponseEntity<String> getPostData(@RequestBody Map<String, Integer> data) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
                .body(this.mBusiness.showUserInformation(data.get("num1"), data.get("num2")));
    }
}