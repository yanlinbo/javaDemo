package com.ylb.demoTest.designPattern.composite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void addComponent(Component component) {
        children.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb = sb.append("-");
        }
        System.out.println(sb.toString()+name);
        children.forEach(component -> component.display(depth+2));
    }
}
