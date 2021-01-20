package com.desperado;


import org.junit.Test;

public class Problems_03_Longest_Substring_Without_Repeating_Characters {


     /**
      * 解题思路
      * 将字符串转为ascii，然后将其映射在位图中，存在为1，不存在未0，
      * 然后找出连续最长的1即可
      */
     private int lengthOfLongestSubstringOfBitmap(String s){

          if(s == null || s.length() ==0){
               return 0;
          }
          int length = s.length();
          // 扩展ASCII码的位图表示(BitSet),共有256位
          int[] bitSet = new int[256];
          int result = 0;
          int left = 0;
          int right = 0;
          while (left < length){
               if(right < length && bitSet[s.charAt(right)] ==0){
                    // 标记对应的ASCII码为1
                    bitSet[s.charAt(right)] = 1;
                    right++;
               }else{
                    // 标记对应的ASCII码为0
                    bitSet[s.charAt(left)] = 0;
                    left++;
               }
               result = Math.max(result, right - left);
          }
          return result;
     }



     /**
      * 解题思路
      * 滑动窗⼝的右边界不断的右移，只要没有重复的字符，就持续向右扩⼤窗⼝边界。⼀旦出现了重复字
      * 符，就需要缩⼩左边界，直到重复的字符移出了左边界，然后继续移动滑动窗⼝的右边界。以此类推，
      * 每次移动需要计算当前⻓度，并判断是否需要更新最⼤⻓度，最终最⼤的值就是题⽬中的所求.
      */
     private int lengthOfLongestSubstringOfWindow(String s){
          if(s == null || s.length() ==0){
               return 0;
          }
          int length = s.length();
          int[] freq = new int[256];
          int result = 0;
          int left = 0;
          int right = -1;
          while (left <length){
               if(right + 1 < length && freq[s.charAt(right+1) - 'a'] == 0){
                    freq[s.charAt(right + 1) - 'a']++;
                    right++;
               }else{
                    freq[s.charAt(left) - 'a']--;
                    left++;
               }
               result = Math.max(result, right-left+1);
          }
          return result;
     }


     @Test
     public void test(){
          String s = "abcabcbb";
          System.out.println(lengthOfLongestSubstringOfBitmap(s));
          System.out.println(lengthOfLongestSubstringOfWindow(s));

          s = "bbbbb";
          System.out.println(lengthOfLongestSubstringOfBitmap(s));
          System.out.println(lengthOfLongestSubstringOfWindow(s));

          s = "pwwkew";
          System.out.println(lengthOfLongestSubstringOfBitmap(s));
          System.out.println(lengthOfLongestSubstringOfWindow(s));

          s = "";
          System.out.println(lengthOfLongestSubstringOfBitmap(s));
          System.out.println(lengthOfLongestSubstringOfWindow(s));
     }
}

