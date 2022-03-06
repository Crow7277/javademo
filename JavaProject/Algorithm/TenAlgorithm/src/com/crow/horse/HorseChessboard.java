package com.crow.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {
    private static int X;//表示棋盘的列数
    private static int Y;//表示棋盘的行数
    //创建一个数组标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    //使用一个属性标记是否棋盘的所有位置的都被访问过了
    private static boolean finished;//如果为true表示成功

    public static void main(String[] args) {
        System.out.println("开始");
        //测试马踏棋盘算法是否正确
        X = 8;
        Y = 8;
        int row = 1;//马儿初始位置的行，从1开始编号
        int column = 1;//马儿初始位置的列，从1开始编号
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];//初始都为false
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + " ms");
        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成马踏棋盘算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前的位置的行，从0开始
     * @param column     马儿当前的位置的列，从0开始
     * @param step       是第几步，初始为1
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        //System.out.println("c");
        chessboard[row][column] = step;
        //马儿当前的位置
        //假设马儿在4,4的位置上，此时row = 4、X = 8、column = 4、visited[36]刚好为马儿所在位置
        visited[row * X + column] = true;//标记该位置已经访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        //对ps进行排序
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);//取出下一个可以走的位置
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {//说明没有访问过
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        //判断马儿是否完成任务，使用step和应该走的步数比较
        //如果没有达到则表示没有完成，整个棋盘置为零
        //step < X * Y成立的情况有两种
        //1.棋盘到目前为止没有走完
        //2.棋盘处于回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 根据当前的位置（Point），计算马儿还能走哪些位置（Point）
     * 并且放入到一个集合中（ArrayList），最多有8个位置
     *
     * @param curPoint
     * @return 集合
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();
        //创建Point
        Point p1 = new Point();
        //p1.x = curPoint.x - 2 相当于马儿向左走两列
        //p1.y = curPoint.y - 1 相当于马儿向上走一列
        //判断马儿是否可以走位置5
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走位置6
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走位置7
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿是否可以走位置0
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    //使用贪心算法进行优化
    //根据当前这个一步的所有的下一步的选择位置，进行非递减排序,减少回溯的次数
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取o1的下一步的所有位置的个数
                int count1 = next(o1).size();
                //获取o2的下一步的所有位置的个数
                int count2 = next(o2).size();
                if (count1 < count2) return -1;
                else if (count1 == count2) return 0;
                else return 1;
            }
        });
    }
}
