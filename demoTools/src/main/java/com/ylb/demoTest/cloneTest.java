package com.ylb.demoTest;

import com.ylb.domin.Study;

public class cloneTest {

    public Object clone() throws CloneNotSupportedException {
        Study s = (Study) super.clone();
        return s;
    }

    public static void main(String[] args) {
        Study study = new Study();
        study.setId(1).setAdress("陕西省").setAge(18).setName("张三");


    }
}
