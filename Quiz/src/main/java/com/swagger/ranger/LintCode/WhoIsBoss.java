package com.swagger.ranger.LintCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: WhoIsBoss
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/22 15:03
 * @Description: 金花牌比大小
 * @Aha-eureka:
 *******************************************************************************/

public class WhoIsBoss {

    static final String CARDS="23456789HJQKA";
    static final int PAILENGTH = 3;

    public static void main( String[] args ) {
        WhoIsBoss boss = new WhoIsBoss();

        System.out.println(boss.bossValue(boss.change10ToH("A23")));
        System.out.println(boss.whoIsBoss("A23" , "965"));
        System.out.println(boss.whoIsBoss("AAA", "AJQ"));
        System.out.println(boss.whoIsBoss("BBB", "AJQ"));
        System.out.println(boss.whoIsBoss("234", "333"));
        System.out.println(boss.whoIsBoss("KQ10", "AJQ"));
        System.out.println(boss.whoIsBoss("KQ10", "JAQ"));
        System.out.println(boss.whoIsBoss("KQA", "KJQ"));
    }

    /**
     * 谁的牌大谁是BOSS
     * @param player1
     * @param player2
     * @return finalValue[0]:player1大,
     *         finalValue[1]:player2大,
     *         finalValue[2]:一样大；
     *         finalValue[3]：输入不符合
     */
    public int whoIsBoss( String player1, String player2 ) {
        //返回值数组
        int[] finalValue = {1, 0, -1, -2};

        String player1Val = change10ToH(player1);
        String player2Val = change10ToH(player2);

        if (!(isLegal(player1Val) && isLegal(player2Val))) return finalValue[3];
        if(bossValue(player1Val)>bossValue(player2Val)) return finalValue[0];
        if(bossValue(player2Val)>bossValue(player1Val)) return finalValue[1];
        return finalValue[2];
    }

    /**
     * 给一个字符串赋值
     * @param myCard
     * @return
     */
     private int bossValue(String myCard) {
        int count=0;

        int[] vals = new int[PAILENGTH];
        for (int i = 0; i <PAILENGTH ; i++) {
            vals[i] = CARDS.indexOf(myCard.charAt(i)) + 1;
        }
        sortArr(vals);

        //是顺子还是烂牌
        if (vals[0] == vals[1] || vals[1] == vals[2]) {
            count = vals[1] * 200 + vals[2] + vals[0];
        } else {
            count = vals[0] * 100 + vals[1] * 10 + vals[2];
        }

        //是豹子还是顺子
        if (vals[0] == vals[1] && vals[1] == vals[2]) count = vals[0] * 10000;
        if (vals[0]-1 == vals[1] && vals[1]-1 == vals[2]) count = vals[0] * 1000;

        return count;
    }

    //数组排序
    private void sortArr( int[] arr ) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }

            }
        }
    }

    /**
     * 判断是否输入的牌合法
     * @param card
     * @return
     */
    private boolean isLegal( String card ) {
        boolean flag=false;
        if(cardIn(card.charAt(0))&&cardIn(card.charAt(1))&&cardIn(card.charAt(2))) flag = true;
        if(card.length()>3) flag = false;
        return flag;

    }
    //判断点数是否合格
    private boolean cardIn( char i ) {
        boolean flag = false;
        for (int j = 0; j < CARDS.length(); j++) {
            if (i == CARDS.charAt(j)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    /**
     * 将10转化为H，以方便求权重
     * @param s
     */
    private String change10ToH( String s ) {
        return s.replaceAll("10", "H");
    }

}
