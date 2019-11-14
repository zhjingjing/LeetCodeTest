package com.zh.code.test;

import java.math.BigInteger;

/**
 * create by zj on 2019/11/14
 * 字符串转换整数
 *
 * 输入: "42"
 * 输出: 42
 *
 * 输入: "   -42"
 * 输出: -42
 *
 * 输入: "4193 with words"
 * 输出: 4193
 *
 * 输入: "words and 987"
 * 输出: 0（开头是字符，所以无法转换整数）
 *
 * 输入: "-91283472332"
 * 输出: -2147483648（小于int的最小值，所以转换后为Integer.MIN_VALUE=）
 *
 *
 */
public class AtoiTest {

    public static void main(String[] args){

        System.out.println(atoi("4193 with words"));
    }

    public static int atoi(String str){
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        int i = 0;
        //2.判断数字的符号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10)
                return Integer.MAX_VALUE;
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10)
                return Integer.MAX_VALUE;
            if (flag < 0 && -res < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + ch - '0';
        }
        return res * flag;
    }
}
