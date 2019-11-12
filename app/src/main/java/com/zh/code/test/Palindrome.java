package com.zh.code.test;

/**
 * create by zj on 2019/11/12
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 暴力法：遍历所有的子串，判断是否是回文，并记录最长的string
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                String newS = s.substring(i, j);
                if (result.length() <= newS.length() && isPalindrome(newS)) {
                    result = newS;
                }

            }
        }
        return result;
    }

    /**
     * @return 判断首尾对应的值是否相等
     */
    public static boolean isPalindrome(String s) {
        int size = s.length();
        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
