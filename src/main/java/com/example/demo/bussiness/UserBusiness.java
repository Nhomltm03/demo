package com.example.demo.bussiness;

import com.example.demo.model.UserInformation;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    @Autowired
    UserRepository mRepository;

    @Autowired
    MongoTemplate mongoTemplate;

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

    public UserInformation createUser(UserInformation userInformation) {
        return this.mRepository.insert(userInformation);
    }

    public UserInformation getUserByName(String userName) {
        return this.mongoTemplate.findOne(new Query(Criteria.where("name").is(userName)), UserInformation.class);
    }

    public UserInformation getUseName(String userName) {
        return this.mRepository.findUserByName(userName);
    }

}