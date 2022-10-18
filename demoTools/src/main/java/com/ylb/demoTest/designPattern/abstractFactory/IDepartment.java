package com.ylb.demoTest.designPattern.abstractFactory;

import com.ylb.demoTest.designPattern.abstractFactory.entity.Department;

public interface IDepartment {
    void insert(Department department);
    Department getDepartment(int id);
}
