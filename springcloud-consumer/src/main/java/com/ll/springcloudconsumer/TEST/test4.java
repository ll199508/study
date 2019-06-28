package com.ll.springcloudconsumer.TEST;

public class test4 {
    public static void main(String[] args) {
        testss();

    }
    public static void testss(){
        int i = 1;

        try {
            i++;

            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i=5;
        }
        System.out.println(i);
    }
}
