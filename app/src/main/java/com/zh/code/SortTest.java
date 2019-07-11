package com.zh.code;

import java.util.Arrays;

/**
 * create by zj on 2019/7/9
 */
public class SortTest {
    private static int[] array={2,1,5,4,3,8,7,6};
    public static void main(String args[]){
        BubbleSort(array);
        selectSort(array);
        quickTest();
    }

    public static void quickTest(){
        int[] test={2,1,5,4,3,8,7,6,9,10};
        quickSort(test,0,test.length-1);
        System.out.println(Arrays.toString(test));
    }

    /**
     * @param arr
     * 冒泡排序
     *  从后向前冒泡，比较相邻两个元素的大小，小的往前排。
     */
    public static void BubbleSort(int[] arr){
        int size=arr.length;
        for (int i=0;i<size-1;i++){
            for (int j=size-1;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * 选择排序：
     * 选择排序和冒泡类似，都是第一次循环将最小值放到最前面，但不同于冒泡的之比较相邻俩数，
     * 选择是对整体比较，比如第一次比较，拿第一个数与后面的所有值比较；
     *
     */
    public static void selectSort(int[] arr){
        int size=arr.length;
        int pos=0;
        for (int i=0;i<size-1;i++){
            pos=i;
            for (int j=i+1;j<size;j++){
                if (arr[pos]>arr[j]){
                    pos=j;
                }
            }

            if (i!=pos){
                int temp=arr[i];
                arr[i]=arr[pos];
                arr[pos]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 快速排序：是由冒泡演化而来，之所以比冒泡快，是因为使用了分治法。
     * 1:先取得一个基准数
     * 2：将小于基准数的放到右边，大于基准数的放到左边。
     * 3:在对左右区间重复第二步，直到只有一个数为止。
     *
     * 每一轮的比较都需要所有元素，所以时间复杂度是O(n),遍历的轮数平均状态下需要log(n),所以快排的时间复杂度是O(nlog(n))
     *
     * 基准元素的选择：最简单的就是使用第一个元素，当然这种选择会有一个问题就是，原本就是有序的数组，希望逆序排列时，使用快排就会增加时间复杂度，因为轮数变成了n伦。
     * 所以，我们可以随机选择一个元素作为基准元素。
     *
     *  举个例子吧：
     *  【4,7,6,5,3,2,8,1】
     *  将基准元素设置为数组的第一个元素，即4。
     *  双边循环：
     *  设置两个指针分别指向4和1，start 和end。
     *  这时候就可以准备第一轮遍历了。
     *  整体的逻辑是：arr[end]如果大于等于基准元素，则指针左移，否则停止，切换到arr[start]判断。如果arr[start]小于等于基准元素则指针右移，否则停止移动，交换arr[start]和arr[end]
     *
     *  1:首先判断arr[end]=1小于4，停止移动指针，切换arr[start];
     *   arr[start]=4,右移指针，arr[start]=7大于4停止移动，交换元素。
     *   此时数组为 【4，1，6，5，3，2，8，7】start位于1，end位于7
     *  2 ：
     *   arr[end]=7>4左移，arr[end]=8>4左移，arr[end]=2停止。
     *   arr[start]=1右移，arr[start]=6停止，交换2和6.
     *    此时数组为 【4，1，2，5，3，6，8，7】start位于2，end位于6
     *  3：   arr[end]=6>4左移，arr[end]=3停止。
     *     arr[start]=2右移，arr[start]=5停止，交换3和5.
     *此时数组为 【4，1，2，3，5，6，8，7】start位于3，end位于5
     *
     * 4：  arr[end]=5>4左移，arr[end]=3停止。
     *   此时：arr[start]=arr[end]=3;
     *   交换基准元素与3
     *   此时数组为 【3，1，2，4，5，6，8，7】;
     *   这时候快排的第一轮比较结束。
     *
     */
    public static void quickSort(int[] arr,int start,int end){
        //递归结束条件
        if (start>=end){
            return;
        }
        int pivotIndex=exchange(arr,start,end);
        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);
    }

    /**
     * @param arr
     * @param start
     * @param end
     * @return
     * 快排数据交换过程，返回基准元素下标
     */
    public static int exchange(int[] arr,int start,int end){
        //分治交换元素，获取基准元素坐标。

        //定义第一个元素为基准元素
        int pivot=arr[start];
        int left=start;
        int right=end;
        while (left!=right){
            while (arr[right]>pivot&&left<right){
                right--;
            }
            while (arr[left]<=pivot&&left<right){
                left++;
            }

            if (left<right){
                int temp=arr[right];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        //基准元素与left和right重叠时的元素交换
        arr[start]=arr[left];
        arr[left]=pivot;

        return left;
    }


}
