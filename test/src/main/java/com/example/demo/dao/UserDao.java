package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Integer> {

    public User getByUserId(int id);

    public User getByUserIdLike(int id);

}
