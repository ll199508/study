package com.ll.consumer.config;

public class MonitorUtil {
    private static ThreadLocal<Long> t = new ThreadLocal<>();

    public static void start(){
        t.set(System.currentTimeMillis());
        System.out.println(t.get());
    }
    public static void finsh(String methodName){
        Long finshTime = System.currentTimeMillis();
        System.out.println(finshTime);
        System.out.println(methodName+"执行了"+(finshTime-t.get()));
    }
}
