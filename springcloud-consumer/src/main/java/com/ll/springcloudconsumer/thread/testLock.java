package com.ll.springcloudconsumer.thread;

public class testLock {
    public static void main(String[] args) {
        ThreadSynchronizedSecurity t = new ThreadSynchronizedSecurity();
        t.tickets++;
        ThreadLockSecurity.SellTickets sell = new ThreadLockSecurity().new SellTickets();
        Thread thread1 = new Thread(sell, "5号窗口");
        thread1.start();
    }
}
