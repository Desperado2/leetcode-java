package com.desperado;


import org.junit.Test;

public class Problems_09_Palindrome_Number {


    /**
     * 解题思路
     * 判断⼀个整数是不是回⽂数。
     * 简单题。注意会有负数的情况，负数，个位数，10 都不是回⽂数。其他的整数再按照回⽂的规则判断
     */
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        char[] s = String.valueOf(x).toCharArray();
        int length = s.length;
        for (int i = 0; i <= length / 2; i++) {
            if(s[i] != s[length-1-i]){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
