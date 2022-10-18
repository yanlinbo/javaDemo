package com.ylb.demoTest.designPattern.abstractFactory;

import com.ylb.demoTest.designPattern.abstractFactory.entity.User;

public interface IUser {
    void insert(User user);
    User getUser(int id);
}
