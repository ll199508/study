package com.ll.springcloudconsumer.TEST;

public class testt {
    void testThrows() throws NullPointerException{

    }
    public void test(){
        try {
            testThrows();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
