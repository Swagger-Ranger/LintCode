package com.swagger.ranger.LintCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: DigitCounts
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/13 0:02
 * @Description: 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 *
 * 样例 1：
 *
 * 输入：
 * k = 1, n = 1
 * 输出：
 * 1
 * 解释：
 * 在 [0, 1] 中，我们发现 1 出现了 1 次 (1)。
 * ------------------------------------------------------
 * 样例 2：
 *
 * 输入：
 * k = 1, n = 12
 * 输出：
 * 5
 * 解释：
 * 在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)。
 *
 *
 * @Aha-eureka:
 *******************************************************************************/

public class DigitCounts {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }

    /**
     * 单个判断是否相同：即一个数中有多少个相同的单个数
     * @param i
     * @param k
     * @return
     */
    public int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {  //----关键所在：求模
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }
}
