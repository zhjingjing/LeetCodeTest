package com.zh.code.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by zj on 2020/5/6
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 */
public class TwoSum {
    public static void main(String[] args) {
    }

    //读题大哥，每种只会对应一个答案
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        Integer[] newNums = list.toArray(new Integer[]{});

        int[] newNum = new int[newNums.length];
        for (int i = 0; i < newNums.length; i++) {
            newNum[i] = newNums[i];
        }
        return newNum;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //速度最快，
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (map.containsKey(s)) {
                return new int[]{i, map.get(s)};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
