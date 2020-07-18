package com.example.demo.repository;

import com.example.demo.model.UserInformation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserInformation, String> {

    @Query(value = "{_id: ?0}")
    UserInformation findUserById(String id);

    @Query(value = "{name: ?0}")
    UserInformation findUserByName(String name);

    @Query(value = "{age: ?0}")
    UserInformation findUserByAge(String age);

}