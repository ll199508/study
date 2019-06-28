package com.ll.springcloudconsumer.controller;

import java.util.HashMap;
import java.util.Map;

public class testController2 {
        public static void main(String[] args){
            System.out.println(Fribonacci(30));

        }
        public static int Fribonacci(int n){
            if(n<=2)
                return 1;
            else
                return Fribonacci(n-1)+Fribonacci(n-2);

        }
    }

