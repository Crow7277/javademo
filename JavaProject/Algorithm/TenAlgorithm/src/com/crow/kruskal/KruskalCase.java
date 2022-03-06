package com.crow.kruskal;

import java.util.Arrays;

public class KruskalCase {
    private int edgeNum;//记录边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    //INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                //     A    B    C    D    E    F   G
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 07, INF, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, INF}};
        //创建实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        System.out.println("未排序：");
        System.out.println(Arrays.toString(edges));

        System.out.println("排序后：");
        kruskalCase.sortEdges(edges);
        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        //初始化顶点,使用的是复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] = vertexs[i];
        }
        //初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                //如果不等于INF，说明该边有效
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存已有最小生成树中的每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];
        //获取图中所有边的集合，一共有12条边
        EData[] edges = getEdges();
        System.out.println("图的边的集合 = " + Arrays.toString(edges) + " 共" + edges.length);
        //按照边的权值大小进行排序(从小到大)
        sortEdges(edges);
        //遍历edges，将边添加到最小生成树中，并判断准备假如的边是否构成回路，如果没有加入rets，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd(ends, p2);
            //判断是否构成回路
            if (m != n) {//不构成回路
                //[0,0,0,0,5,0,0,0,0,0,0,0,0]；表示下标为4的顶点的终点为5
                ends[m] = n;//设置m在已有最小生成树中的终点
                rets[index++] = edges[i];//有一条边加入到rets数组
            }
        }
        //统计并打印最小生成树,输出rets数组
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }

    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序处理，冒泡排序
     *
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @param ch 顶点的值，比如A，B等
     * @return 返回ch顶点对应的下标，如果找不到返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到EData[]数组中，后面需要遍历该数组
     * 是通过matrix邻接矩阵来获取
     * EData[] 形式[['A','B','12'],['B','F','12'...]
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点（判断回路时使用）
     *
     * @param ends 数组记录了各个顶点对应的终点是哪个，ends数组是在遍历过程中逐步形成的
     * @param i    表传入的顶点的下标
     * @return 返回的是下标为i的顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

//创建一个类EData，它的对象实例表示一条边
class EData {
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //重写toString便于输出
    @Override
    public String toString() {
        return "EData[ <" + start + ", " + end + "> = " + weight + "]";
    }
}