package com.swagger.ranger.LintCode;

import java.util.HashMap;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Two_Sum
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/10 23:34
 * @Description:
 * @Aha-eureka: 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *              你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 *              Example1:
 *              numbers=[2, 7, 11, 15], target=9
 *              return [0, 1]
 *              Example2:
 *              numbers=[15, 2, 7, 11], target=9
 *              return [1, 2]
 *******************************************************************************/

public class Two_Sum {

    /**
     * 思路：使用一个hashmap来存传入数组的值为map键，其值的下标为map值
     *       然后遍历数组判断targe -当前遍历数组值是否已经存在与map中，如果存在则将对应的下标替换到结果数组中，找到并返回
     *       否则就将值添加到map继续遍历
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[]{-1, -1};// 返回结果
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//存储中间值
        if (numbers ==null|| numbers.length<2) return res;

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i;
                break;
            }

            map.put(numbers[i], i);
        }
        return res;
    }
}
