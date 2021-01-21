package com.desperado;


import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class Problems_15_3Sum {


    /**
     * 解题思路
     * ⽤ map 提前计算好任意 2 个数字之和，保存起来，可以将时间复杂度降到 O(n^2)。这⼀题⽐较麻烦的
     * ⼀点在于，最后输出解的时候，要求输出不重复的解。数组中同⼀个数字可能出现多次，同⼀个数字也
     * 可能使⽤多次，但是最后输出解的时候，不能重复。例如 [-1，-1，2] 和 [2, -1, -1]、[-1, 2, -1] 这 3 个解
     * 是重复的，即使 -1 可能出现 100 次，每次使⽤的 -1 的数组下标都是不同的。
     * 这⾥就需要去重和排序了。map 记录每个数字出现的次数，然后对 map 的 key 数组进⾏排序，最后在
     * 这个排序以后的数组⾥⾯扫，找到另外 2 个数字能和⾃⼰组成 0 的组合。
     */
    private List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, (int) IntStream.of(nums).filter(it -> it==num).count());
        }
        List<Integer> uniqNums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : counter.entrySet()) {
            uniqNums.add(integerIntegerEntry.getKey());
        }
        Collections.sort(uniqNums);
        for (int i = 0; i < uniqNums.size(); i++) {
            if((uniqNums.get(i) * 3 == 0 ) && counter.get(uniqNums.get(i)) >= 3){
                res.add(Arrays.asList(uniqNums.get(i),uniqNums.get(i),uniqNums.get(i)));
            }
            for (int j = i + 1; j < uniqNums.size(); j++) {
                if((uniqNums.get(i) * 2 + uniqNums.get(j) == 0) && counter.get(uniqNums.get(i)) > 1){
                    res.add(Arrays.asList(uniqNums.get(i),uniqNums.get(i),uniqNums.get(j)));
                }
                if((uniqNums.get(j) * 2 + uniqNums.get(i) == 0) && counter.get(uniqNums.get(j)) > 1){
                    res.add(Arrays.asList(uniqNums.get(i),uniqNums.get(j),uniqNums.get(j)));
                }
                int c = 0 - uniqNums.get(i) - uniqNums.get(j);
                int counterc = counter.getOrDefault(c, 0);
                if(c > uniqNums.get(j) && counterc > 0){
                    res.add(Arrays.asList(uniqNums.get(i),uniqNums.get(j),c));
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0}));
    }
}
