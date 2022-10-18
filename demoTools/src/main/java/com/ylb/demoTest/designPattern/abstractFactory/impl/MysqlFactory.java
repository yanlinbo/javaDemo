package com.ylb.demoTest.designPattern.abstractFactory.impl;

import com.ylb.demoTest.designPattern.abstractFactory.IFactory;
import com.ylb.demoTest.designPattern.abstractFactory.entity.Department;
import com.ylb.demoTest.designPattern.abstractFactory.entity.User;

public class MysqlFactory implements IFactory {
    @Override
    public User createUser() {
        return null;
    }

    @Override
    public Department createDepartment() {
        return null;
    }
}
