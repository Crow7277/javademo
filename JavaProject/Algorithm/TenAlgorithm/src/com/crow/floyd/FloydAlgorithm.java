package com.crow.floyd;

import java.util.Arrays;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        //创建图对象
        Graph graph = new Graph(vertex.length, matrix, vertex);
        //弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}

//创建图
class Graph {
    private char[] vertex;//存放顶点的数组
    private int[][] dis;//距离表，保存从各个顶点出发到其他顶点的距离，最后的结果也算保留在该数组中
    private int[][] pre;//前驱表，保存到达目标顶点的前驱顶点


    /**
     * 构造器
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //对pre数组初始化，注意，存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //显示pre数组和dis数组
    public void show() {
        //为了便于阅读，优化输出
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            //输出pre数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.print("(" + vertex[k] + "到" + vertex[i] + "的最短路径是：" + dis[k][i] + ") ");
            }
            System.out.println();
            System.out.println();
        }
    }

    //弗洛伊德算法
    public void floyd() {
        int len = 0;
        //对中间顶点的遍历,k为中间顶点的下标
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发[A,B,C,D,E,F,G]
            for (int i = 0; i < dis.length; i++) {
                //j顶点[A,B,C,D,E,F,G]
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];//从i顶点出发，经过k这个中间顶点，到达j顶点的距离
                    if (len < dis[i][j]) {//如果len小于i顶点到j顶点值小于直连的距离
                        dis[i][j] = len;//更新距离
                        pre[i][j] = pre[k][j];//更新前驱顶点
                    }
                }
            }
        }
    }
}
