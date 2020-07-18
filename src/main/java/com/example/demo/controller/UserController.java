package com.example.demo.controller;

import com.example.demo.bussiness.UserBusiness;
import com.example.demo.model.UserInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBusiness mBusiness;

    @Autowired
    private ObjectMapper mMapper;

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

    @PutMapping("/push")
    public ResponseEntity<String> getPushData(@RequestBody Map<String, Integer> data) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("");
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUserInfo(@RequestBody String data) {
        try {
            UserInformation userInformation = this.mMapper.readValue(data, UserInformation.class);
            this.mBusiness.createUser(userInformation);
            return ResponseEntity.status(HttpStatus.OK).body("Create Sucsses");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<UserInformation> getUserByName(@RequestParam(name = "name") String data) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.mBusiness.getUserByName(data));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.TEXT_PLAIN).body(null);
        }
    }
}