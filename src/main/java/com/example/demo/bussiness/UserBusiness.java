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

}