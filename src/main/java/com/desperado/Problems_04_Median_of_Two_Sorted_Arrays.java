package com.desperado;


import org.junit.Test;

public class Problems_04_Median_of_Two_Sorted_Arrays {

    /**
     * 给出两个有序数组，要求找出这两个数组合并以后的有序数组中的中位数。要求时间复杂度为
     * O(log (m+n))。
     *
     * 这⼀题最容易想到的办法是把两个数组合并，然后取出中位数。但是合并有序数组的操作是
     * O(max(n,m)) 的，不符合题意。看到题⽬给的 log 的时间复杂度，很容易联想到⼆分搜索。
     *
     * 由于要找到最终合并以后数组的中位数，两个数组的总⼤⼩也知道，所以中间这个位置也是知道
     * 的。只需要⼆分搜索⼀个数组中切分的位置，另⼀个数组中切分的位置也能得到。为了使得时间复
     * 杂度最⼩，所以⼆分搜索两个数组中⻓度较⼩的那个数组。
     *
     * 关键的问题是如何切分数组 1 和数组 2 。其实就是如何切分数组 1 。先随便⼆分产⽣⼀个
     * midA，切分的线何时算满⾜了中位数的条件呢？即，线左边的数都⼩于右边的数，即，
     * nums1[midA-1] ≤ nums2[midB] && nums2[midB-1] ≤ nums1[midA] 。如果这些条件都不满
     * ⾜，切分线就需要调整。如果 nums1[midA] < nums2[midB-1]，说明 midA 这条线划分出来左
     * 边的数⼩了，切分线应该右移；如果 nums1[midA-1] > nums2[midB]，说明 midA 这条线划分
     * 出来左边的数⼤了，切分线应该左移。经过多次调整以后，切分线总能找到满⾜条件的解。
     *
     * 假设现在找到了切分的两条线了，数组 1 在切分线两边的下标分别是 midA - 1 和 midA。数
     * 组 2 在切分线两边的下标分别是 midB - 1 和 midB。最终合并成最终数组，如果数组⻓度是奇
     * 数，那么中位数就是 max(nums1[midA-1], nums2[midB-1])。如果数组⻓度是偶数，那么中间
     * 位置的两个数依次是：max(nums1[midA-1], nums2[midB-1]) 和 min(nums1[midA],
     * nums2[midB])，那么中位数就是 (max(nums1[midA-1], nums2[midB-1]) +
     * min(nums1[midA], nums2[midB])) / 2。
     */
    private float findMedianSortedArrays(int[] nums1, int[] nums2){
        // 假设nums1的长度大
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = nums1.length;
        int k = (nums1.length + nums2.length + 1)>>1;
        int nums1Mid = 0;
        int nums2Mid = 0;
        while (low <= high){
            // nums1: ……………… nums1[nums1Mid-1] | nums1[nums1Mid] ……………………
            // nums2: ……………… nums2[nums2Mid-1] | nums2[nums2Mid] ……………………
            nums1Mid = low + ((high - low) >> 1);
            nums2Mid = k - nums1Mid;
            if(nums1Mid > 0 && nums1[nums1Mid - 1] > nums2[nums2Mid]){
                // nums1 中的分界线划多了，要向左边移动
                high = nums1Mid - 1;
            }else if(nums1Mid != nums1.length && nums1[nums1Mid] < nums2[nums2Mid-1]){
                // nums1 中的分界线划少了，要向右边移动
                low = nums1Mid + 1;
            }else{
                // 找到合适的划分了，需要输出最终结果了
                // 分为奇数偶数 2 种情况
                break;
            }
        }
        int midLeft = 0;
        int midRight = 0;
        if(nums1Mid == 0){
            midLeft = nums2[nums2Mid - 1];
        }else if(nums2Mid == 0){
            midLeft = nums1[nums1Mid - 1];
        }else {
            midLeft = Math.max(nums1[nums1Mid -1],nums2[nums2Mid-1]);
        }
        if(((nums1.length + nums2.length)&1) == 1){
            return midLeft;
        }
        if(nums1Mid == nums1.length){
            midRight = nums2[nums2Mid];
        }else if(nums2Mid == nums2.length){
            midRight = nums1[nums1Mid];
        }else {
            midRight = Math.min(nums1[nums1Mid], nums2[nums2Mid]);
        }
        return (float) ((midLeft + midRight) / 2.0);
    }

    @Test
    public void test(){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));


        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));


        nums1 = new int[]{0,0};
        nums2 = new int[]{0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));

        nums1 = new int[]{};
        nums2 = new int[]{1};
        System.out.println(findMedianSortedArrays(nums1,nums2));

        nums1 = new int[]{2};
        nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
