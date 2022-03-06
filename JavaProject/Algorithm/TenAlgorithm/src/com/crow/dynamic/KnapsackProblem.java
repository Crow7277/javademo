package com.crow.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数
        //为了记录放入商品的情况，定义二维数组
        int[][] path = new int[n + 1][m + 1];

        //创建二位数组
        //v[i][j]表示再前i个物品中可以装入容量为j的背包的最大值
        int[][] v = new int[n + 1][m + 1];
        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0；
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置为0
        }
        //根据公式进行动态规划
        for (int i = 1; i < v.length; i++) {//不处理第一行，i是从1开始的
            for (int j = 1; j < v[0].length; j++) {//不处理第一列，j是从1开始的
                if (w[i - 1] > j) {//因为程序的i是从1开始的，因此原来的公式中的w需要修改成从0开始
                    v[i][j] = v[i - 1][j];
                } else {
                    //因为i是从1开始的，因此w和v都要调整成 i - 1
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，所以使用if-else语句实现判断最大值
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //记录最优情况
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        //输出v
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        //输出放入的是哪些商品
        //遍历path会把所以的放入情况都得到，其实只需要最后的放入
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.printf("第%d个商品放入到了背包\n", i);
//                }
//            }
//        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {//从path数组最后开始找
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到了背包\n", i);
                //调整背包容量
                j -= w[i - 1];
            }
            i--;
        }
    }
}
