package com.example.demo.bussiness;

import com.example.demo.model.UserInformation;

import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    public UserInformation getUserInformation() {
        UserInformation mInformation = new UserInformation();
        mInformation.setId("345");
        mInformation.setName("Nguyen Thanh Dat");
        mInformation.setAge(23);
        return mInformation;
    }

    public String showUserInformation(int num1, int num2) {
        int result = num1 + num2;
        return "Result :" + result;
    }

}