package com.ylb.demoTest.designPattern.abstractFactory.impl;

import com.ylb.demoTest.designPattern.abstractFactory.IUser;
import com.ylb.demoTest.designPattern.abstractFactory.entity.User;

public class OracleUser implements IUser {
    @Override
    public void insert(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
