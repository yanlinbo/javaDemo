package com.ylb.demoTest.designPattern.abstractFactory.impl;

import com.ylb.demoTest.designPattern.abstractFactory.IDepartment;
import com.ylb.demoTest.designPattern.abstractFactory.IUser;
import com.ylb.demoTest.designPattern.abstractFactory.entity.Department;
import com.ylb.demoTest.designPattern.abstractFactory.entity.User;

public class MysqlDepartment implements IDepartment {

    @Override
    public void insert(Department department) {

    }

    @Override
    public Department getDepartment(int id) {
        return null;
    }
}
