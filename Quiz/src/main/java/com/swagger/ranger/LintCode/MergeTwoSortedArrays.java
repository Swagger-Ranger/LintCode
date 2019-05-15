package com.swagger.ranger.LintCode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MergeTwoSortedArrays
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/14 9:47
 * @Description: 合并两个有序数组,合并两个有序升序的整数数组A和B变成一个新的数组。新数组也要有序
 *
 * 样例 1:
 * 输入: A=[1], B=[1]
 * 输出:[1,1]
 * 样例解释: 返回合并后的数组。
 *
 * 样例 2:
 * 输入: A=[1,2,3,4], B=[2,4,5,6]
 * 输出: [1,2,2,3,4,4,5,6]
 * 样例解释: 返回合并后的数组
 *
 * @Aha-eureka:  思路，把小的合并到大的数组，并根据前一个以插入的位置开始查找插入位置，往后插入
 *******************************************************************************/

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) return null;


        int[] mergeArray = new int[A.length + B.length];

        int index_A = 0, index_B = 0, index_merge = 0;

        while (index_A < A.length && index_B < B.length) {
            if (A[index_A] < B[index_B]) mergeArray[index_merge++] = A[index_A++];
            else mergeArray[index_merge++] = B[index_B++];
        }

        while (index_A < A.length) mergeArray[index_merge++] = A[index_A++];
        while (index_B < B.length) mergeArray[index_merge++] = B[index_B++];

        return mergeArray;
    }

    public static void main( String[] args ) {
        int[] a = {1, 3, 5};
        int[] b = {4};

        int[] c = mergeSortedArray(a, b);
        System.out.println(Arrays.toString(c));
    }


}

