package com.crow.dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;//表示不可连接
        //邻接矩阵
        int[][] matrix = new int[][]{
                //     A  B  C  D  E  F  G
                /*A*/ {N, 5, 7, N, N, N, 2},
                /*B*/ {5, N, N, 9, N, N, 3},
                /*C*/ {7, N, N, N, 8, N, N},
                /*D*/ {N, 9, N, N, N, 4, N},
                /*E*/ {N, N, 8, N, N, 5, 4},
                /*F*/ {N, N, N, 4, 5, N, 6},
                /*G*/ {2, 3, N, N, 4, 6, N}};

        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.show();
    }
}

//创建图
class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//表示已经访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //显示结果
    public void show() {
        vv.show();
    }


    /**
     * 迪杰斯特拉算法算法实现
     *
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     *
     * @param index
     */
    private void update(int index) {
        int len = 0;
        //根据遍历邻接矩阵的matrix[index]
        for (int j = 0; j < matrix[index].length; j++) {
            //len含义是：出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            //如果j顶点没有被访问过并且len小于出发顶点到j顶点的距离，就更新
            if (!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index);//更新j顶点到前驱为index顶点
                vv.updateDis(j, len);//更新出发顶点到j顶点的距离
            }
        }
    }
}

//已访问顶点集合
class VisitedVertex {
    //记录各个顶点是否访问过，1表示访问过，0表示未访问，会动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标，会动态更新
    public int[] pre_visited;
    //记录出发定点到其他所有顶点的距离
    //比如G为出发顶点，就会记录G到其他顶点的距离，会动态更新，求的最短距离会被存放到dis
    private int[] dis;

    /**
     * 构造器
     *
     * @param length 表示顶点的个数
     * @param index  出发顶点对应的下标，比如G顶点，下标就是6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;//设置出发顶点诶访问过
        dis[index] = 0;//设置出发顶点的访问距离为零
    }

    /**
     * 判断index顶点是否被访问过
     *
     * @param index 顶点下标
     * @return 如果访问过返回true，否则返回false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        this.dis[index] = len;
    }

    /**
     * 更新pre顶点的前驱顶点为index顶点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        this.pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     *
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择返回新的访问订单，比如这里的G完后，就是A点作为新的访问顶点（注意不是出发顶点）
     *
     * @return
     */
    public int updateArr() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index被访问过
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果,即输出三个数组的情况
    public void show() {
        System.out.println("========================");
        //输出already_arr
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis数组
        for (int i : dis) {
            System.out.print(i + " ");
        }
    }
}