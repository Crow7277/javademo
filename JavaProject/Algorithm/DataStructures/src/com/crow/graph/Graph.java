package com.crow.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * User crow7
 * Date 2021/11/29.
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数
    //定义数组boolean[]，记录某个结点是否被访问
    private boolean[] isVisited;

    //构造器
    public Graph(int n) {
        //初始化矩阵
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }


    public static void main(String[] args) {
        //结点的个数
        int n = 5;
        String[] Vertex = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String VertexValue : Vertex) {
            graph.insertVertex(VertexValue);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);//A-B
        graph.insertEdge(0, 2, 1);//A-C
        graph.insertEdge(1, 2, 1);//B-C
        graph.insertEdge(1, 3, 1);//B-D
        graph.insertEdge(1, 4, 1);//B-E
        /*
          显示
          [0, 1, 1, 0, 0]
          [1, 0, 1, 1, 1]
          [1, 1, 0, 0, 0]
          [0, 1, 0, 0, 0]
          [0, 1, 0, 0, 0]
         */
        graph.showGraph();

        System.out.println("DFS");
        //graph.dfs();
        System.out.println("BFS");
        graph.bfs();
    }

    /**
     * 得到第一个邻接结点的下标
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1 当前结点，比如说第一行的情况下，就是A结点
     * @param v2 A的下一个邻接结点，也就是B，但是由于B已经被访问了，所以才要查找B之后的邻接结点
     * @return 邻接结点，如果没有的话就返回-1
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //DFS
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该结点
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置为已经访问
        isVisited[i] = true;

        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);//如果是A结点的话，那下一个应该是B
        //说明有
        while (w != -1) {//如果B未被访问，则对B进行dfs
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问
            w = getNextNeighbor(i, w);//如果B已经被访问了，就查找下一个也就是C
        }
    }

    //对dfs重载，遍历所有的结点，并进行dfs
    public void dfs() {
        //遍历所有的结点
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u;//表示队列头结点对应的下标
        int w;//邻接结点下标w
        //队列，记录结点访问顺序
        Deque queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将结点借入队列
        queue.offerLast(i);

        while (!queue.isEmpty()) {
            //取出队列头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标
            w = getFirstNeighbor(u);
            //说明找到邻接点
            while (w != -1) {
                //判断是否访问
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队列
                    queue.offerLast(w);
                }
                //如果已经访问过
                //以u为前驱结点，找w后面的下一个邻接结点
                w = getNextNeighbor(u, w);//体现出广度优先探索
            }
        }
    }

    //遍历所有的结点进行广度优先探索
    private void bfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i])
                bfs(isVisited, i);
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i（下标）对应的的数据 0->A,1->B,2->C
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标，即第几个顶点
     * @param v2     表示第二个顶点点的下标
     * @param weight 权值，为0和1，0表示不能相连，1表示可以相连
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        //由于是无向图，此时反过来也要添加权值
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}