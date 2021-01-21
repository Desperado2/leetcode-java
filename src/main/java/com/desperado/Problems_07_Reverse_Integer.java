package com.desperado;

import org.junit.Test;

public class Problems_07_Reverse_Integer {


    /**
     *解题思路
     * 这⼀题只需要注意⼀点，反转以后的数字要求在 [−2^31, 2^31 − 1]范围内，超过这个范围的数字
     * 都要输出 0 。
     */
    private int reverse(int x){
        int tmp = 0;
        while (x != 0){
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        if (tmp > (1<< 31-1) || tmp < -(1<<31)){
            return 0;
        }
        return tmp;
    }

    @Test
    public void test(){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }
}
