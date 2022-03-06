package com.crow.recursion;

/**
 * User crow7
 * Date 2021/10/29.
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用数字1，表示墙
        //将上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        //使用递归回溯找路，路径下右上左
        //setWay(map, 1, 1);
        //使用递归回溯找路，路径上右下左
        setWay1(map, 1, 1);
        //输出新的地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 使用递归回溯来给小球找路
     * 如果小球到了 map[6][5]这个位置，到达终点
     * 约定：当map[i][j] = 0 时，表示没有走过，
     * 当为1时，表示墙
     * 当为2时，是通路可以走
     * 当为3时，表示该位置已经走过但是走不通
     * 在走迷宫是需要确定一个策略（方法）下 -> 右 -> 上 -> 左，如果走不通再回溯
     *
     * @param map 表示地图
     * @param i   表示从那个位置开始
     * @param j   表示从那个位置开始
     * @return 如果找到桐庐，返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            //如果当前点还没有走过
            if (map[i][j] == 0) {
                //按照策略下 -> 右 -> 上 -> 左
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0，可能是1，2，3
                return false;
            }

        }
    }
    //找路策略改为上 -> 右 -> 下 -> 左
    public static boolean setWay1(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            //如果当前点还没有走过
            if (map[i][j] == 0) {
                //按照策略下 -> 右 -> 上 -> 左
                map[i][j] = 2;//假定该点可以走通
                if (setWay1(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay1(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay1(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay1(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0，可能是1，2，3
                return false;
            }

        }
    }
}
