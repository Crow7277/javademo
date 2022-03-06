package com.crow.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵
        //10000表示不连通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.creatGraph(mGraph, verxs, data, weight);
        minTree.showGraph(mGraph);
        //测试普利姆算法,从A开始
        minTree.prim(mGraph, 1);
    }
}

//创建最小生成树
class MinTree {
    /**
     * 创建图的邻接矩阵
     *
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void creatGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }


    /**
     * 编写Prim算法，得到最小生成树
     *
     * @param graph 图
     * @param v     表示从图的底几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        //标记结点是否被访问过,java中visited默认位0因此不需要初始化
        int[] visited = new int[graph.verxs];
        //把当前结点标记为已访问
        visited[v] = 1;
        //h1,h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE;//将minWeight初始成一个大数，在后面比那里过程中会被替换
        for (int k = 1; k < graph.verxs; k++) {//因为有graph.verxs个顶点，普利姆算法结束后有graph.verxs-1条边

            //确定每一次生成的子图和哪个结点和当前结点的距离最近
            for (int i = 0; i < graph.verxs; i++) {//i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j结点表示未被访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight（寻找已经访问过的结点和未访问结点间的权值最小的边）
                        minWeight = graph.weight[i][j];
                        //记录顶点下班
                        h1 = i;
                        h2 = j;
                    }
                }
            }//退出这个for循环表示找到了一条边
            System.out.println("边 < " + graph.data[h1] + "," + graph.data[h2] + " > 权值：" + minWeight);
            //将当前结点标记为已访问
            visited[h2] = 1;
            //重置minWeight
            minWeight = Integer.MAX_VALUE;
        }
    }
}

class MGraph {
    int verxs;//表示图的结点个数
    char[] data;//存放结点数据
    int[][] weight;//存放边，邻接矩阵

    public MGraph(int verx) {
        this.verxs = verx;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}