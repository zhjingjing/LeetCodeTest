package com.zh.code.test;

/**
 * create by zj on 2019/11/15
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class WaterContainer {
    public static void main(String[] arg) {
        int[] array=new int[]{1,1};
        System.out.println(getMaxContainer(array));
        System.out.println(getMaxContainer2(array));
    }


    public static int getMaxContainer(int[] array){
        int result=0;
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                int min=Math.min(array[i],array[j]);
                if (result<min*(j-i)){
                    result=min*(j-i);                }
            }
        }
        return result;
    }


    /**
     * @param arr
     * @return
     * 双指针法
     */
    public static int getMaxContainer2(int[] arr){
        int result=0;
        int left=0;int right=arr.length-1;

        while (left<right){
            result=Math.max(result,Math.min(arr[left],arr[right])*(right-left));
            if (arr[left]<arr[right]){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
