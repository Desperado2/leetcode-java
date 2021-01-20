import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problems_01_Two_Sum {

    /**
     * 解题思路
     * 这道题最优的做法时间复杂度是 O(n)。
     * 顺序扫描数组，对每⼀个元素，在 map 中找能组合给定值的另⼀半数字，如果找到了，直接返回 2 个
     * 数字的下标即可。如果找不到，就把这个数字存⼊ map 中，等待扫到“另⼀半”数字的时候，再取出来返
     * 回结果。
     */
    private static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if(map.containsKey(another)){
                return new int[]{map.get(another), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    // 测试
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
