package realize.sort.practice;

import java.util.*;

public class Test {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     **/
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target-nums[i], i);
        }
        return result;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[]result = new int[k];
        HashMap<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        // 计数每个数字出现的次数.
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            Integer count2 = count == null ? 1 : ++count;
            countMap.put(nums[i],count2);
        }
        int i = 0;
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(countMap.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> integerIntegerEntry : list) {
            result[i] = integerIntegerEntry.getKey();
            if(++i>k-1) return result;
        }
        return null;
    }

    /**
     * 某商超老板因找零需要，现需要将10张百元人民币，更换成10元、20元、50元面值的人民币。
     * 请通过程序实现求出有多少种更换零钱的组合方式。
     * @param args
     */
    void test(){


        
    }

    public static void main(String[] args) {
        Test test = new Test();
        int []nums = {4,1,-1,2,-1,2,3};int k = 2;
        int[] ints = test.topKFrequent(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }




}
