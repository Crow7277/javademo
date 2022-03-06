package com.crow.sqarasearry;

/**
 * 稀疏数组
 * User crow7
 * Date 2021/10/19.
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0：没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        //将二维数组转换为稀疏数组
        //1.先遍历二维数组，得到非零的数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("sum = " + sum);
        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组将非零的值存方到稀疏数组中
        int count = 0;//用于记录是第几个非零数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        //将稀疏数组回复为原始的二维数组
        //1.先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.在读取稀疏数组后的几行数据（从第二行开始），并赋给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            //稀疏数组的第i行第0列表示原数组的行，稀疏数组的第i行第1列表示原数组的列
            //稀疏数组的第i行第2列表示原数组的值
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
