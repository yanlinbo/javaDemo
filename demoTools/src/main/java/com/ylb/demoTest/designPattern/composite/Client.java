package com.ylb.demoTest.designPattern.composite;

public class Client {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.addComponent(new Leaf("LeafA"));
        root.addComponent(new Leaf("LeafB"));
        Composite comp = new Composite("comp");
        comp.addComponent(new Leaf("LeafC"));
        comp.addComponent(new Leaf("LeafD"));
        root.addComponent(comp);
        Composite comp01 = new Composite("comp01");
        comp01.addComponent(new Leaf("LeafE"));
        comp01.addComponent(new Leaf("LeafF"));
        comp.addComponent(comp01);

        root.display(1);
    }
}
