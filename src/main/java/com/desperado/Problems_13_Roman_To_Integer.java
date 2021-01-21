package com.desperado;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Problems_13_Roman_To_Integer {


    /**
     * 解题思路
     * 给定⼀个罗⻢数字，将其转换成整数。输⼊确保在 1 到 3999 的范围内。
     * 简单题。按照题⽬中罗⻢数字的字符数值，计算出对应罗⻢数字的⼗进制数即可。
     */
    private int romanToInt(String s){
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);

        if(s == null || s.length() == 0){
            return 0;
        }
        int num = 0;
        int lastInt = 0;
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            String chars = s.substring(s.length() - (i + 1), s.length() - i);
            num = roman.get(chars);
            if(num < lastInt){
                total = total - num;
            }else {
                total = total + num;
            }
            lastInt = num;
        }
        return total;
    }


    @Test
    public void test(){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
