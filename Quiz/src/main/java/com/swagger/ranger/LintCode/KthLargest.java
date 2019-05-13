package com.swagger.ranger.LintCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: KthLargest
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/9 15:07
 * @Description: 找出第K大的元素
 * 输入：
 * n = 1, nums = [1,3,4,2]
 * 输出：
 * 4
 * @Aha-eureka: 快速排序的简化应用
 *******************************************************************************/

public class KthLargest {

    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main( String[] args ) {
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargestElement(2, new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
