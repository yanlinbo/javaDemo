package com.ylb.domin;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Study implements Cloneable {

    private int id;
    private String name;
    private String adress;
    private int age;
}
