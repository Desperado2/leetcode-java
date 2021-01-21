package com.desperado;


import org.junit.Test;

public class Problems_11_Container_With_Most_Water {


    /**
     * 解题思路
     * 这⼀题也是对撞指针的思路。⾸尾分别 2 个指针，每次移动以后都分别判断⻓宽的乘积是否最⼤。
     */
    private int maxArea(int[] height){
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end){
            int width = end - start;
            int high = 0;
            if(height[start] < height[end]){
                high = height[start];
                start++;
            }else {
                high = height[end];
                end--;
            }
            int temp = width * high;
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }


    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea(new int[]{4,3,2,1,4}));
        System.out.println(maxArea(new int[]{1,2,1}));
    }
}
