package com.swagger.ranger.LintCode;

import java.util.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Ugly_NumberII
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/13 9:28
 * @Description: 寻找丑数：设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 *               要求：O(n)或者O(nlogn)
 *               符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *               即一个数n能够被分解为：n=2^x * 3^y * 5^z;0也是丑数，因为可以写成2，3，5的0次方相乘
 * @Aha-eureka:  要找到第n个丑数，且符合复杂度要求肯定不能使用遍历的方法。
 *               方法一：
 *               使用优先队列，前面的不断出列，优先队列使用二叉树实现了队列头就是指定顺序最小数。然后for循环队列第n个就是第n个丑数
 *               方法二：
 *
 *******************************************************************************/

public class Ugly_NumberII {

    public static int nthUglyNumber(int n ) {

        //丑数顺序队列
        Queue<Long> Q = new PriorityQueue<Long>();
        //所有丑数集合，丑数的生成就是在已有的丑数乘以基数
        HashSet<Long> inQ = new HashSet<Long>();

        //2，3，5基数数组
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);

        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }

        //number第n个数字，第一个为1
        Long number = Long.valueOf(1);

        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                long k = primes[j] * number;
                if (!inQ.contains(k)) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }

    /**
     * 都是使用从1-n去逐步生成丑数，但上一种方法会有大量的计算浪费在了优先队列的排序上，这里直接使用一个arraylist来存丑数队列
     * 空间复杂度和时间复杂度都会提升很多
     * @param n
     * @return
     */
    public static int nthUglyNumber2( int n ) {
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }

        return uglys.get(n - 1);
    }

}