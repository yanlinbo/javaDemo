package com.ylb.demoTest.baseTest;

public class BitOperatorTest {
    public static void main(String[] args) {
//        System.out.println(5 & 9);
//        System.out.println(5 | 9);
//        System.out.println(~-5);

//        for(;;){
//            System.out.println("省略循环条件的三个部分，条件一直为true");
//        }

//        outer:
//        for (int i = 0; i <5 ; i++) {
//            for (int j = 0; j < 3; j++)
//                System.out.println("i的值为"+i+",j的值为"+j);
////                if(j==1){
////                   continue outer;
////                }
//
//        }
//        System.out.println(false ^ false);
//        System.out.println(true ^ false);
//        System.out.println(false ^ true);
//        System.out.println(true ^ true);

        int a=5,b=10;
        if(a > 4 | b++ > 10){
            System.out.println("a的值是"+a+",b的值是"+b);
        }
//        if(a > 4 || b++ > 10){
//            System.out.println("a的值是"+a+",b的值是"+b);
//        }

    }
}
