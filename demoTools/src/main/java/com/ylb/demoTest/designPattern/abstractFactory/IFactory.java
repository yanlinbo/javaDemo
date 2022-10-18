package com.ylb.demoTest.designPattern.abstractFactory;

import com.ylb.demoTest.designPattern.abstractFactory.entity.Department;
import com.ylb.demoTest.designPattern.abstractFactory.entity.User;

public interface IFactory {

    User createUser();

    Department createDepartment();
}
