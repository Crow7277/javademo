package JavaBasic_06_lotterySystem_Project;

import java.util.Scanner;

import JavaBasic_05_Method.Test3_getLottery;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //声明一个二维数组用于存储多注彩票
        int[][] lotteries = new int[0][0];
        //声明一个中间号码
        int[] luckyNum = new int[0];
        o:
        while (true) {
            System.out.println("欢迎使用双色球系统，官方网站：“www.shuangseqiu.com");
            System.out.println("**************请输入菜单选项***************");
            System.out.println("*             1，购买双色球              *");
            System.out.println("*             2，查看双色球              *");
            System.out.println("*             3，查看开奖                *");
            System.out.println("*             4，查看中奖                *");
            System.out.println("*             5，退出系统                *");
            System.out.println("*****************************************");
            System.out.print("请输入选项： ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("运行购买双色球代码");
                    //输入购买的注数
                    System.out.print("请输入购买注数： ");
                    int zs = sc.nextInt();
                    lotteries = new int[zs][];
                    //有程序生成彩票
                    for (int i = 0; i < zs; i++) {
                        lotteries[i] = Test3_getLottery.getLottery();
                    }
                    //提示购买成功
                    System.out.println("购买成功");
                    break;
                case 2:
                    System.out.println("查看我的双色球");
                    if (lotteries.length == 0) {
                        System.out.println("没有购买双色球，请先购买");
                    } else {
                        /*遍历数组*/
                        for (int[] i : lotteries) {
                            for (int a = 0; a < i.length; a++) {
                                if (a == 5) {
                                    System.out.print(i[a] + "\t|\t");
                                } else {
                                    System.out.print(i[a] + "\t");
                                }
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("运行查看开奖代码");
                    //判断是否购买
                    if (lotteries.length == 0) {
                        System.out.println("没有购买双色球，请先购买");
                    } else {
                        //再生成一注双色球，当成中奖号码
                        luckyNum = Test3_getLottery.getLottery();
                        //查看中奖号码
                        System.out.println("中奖号码为：");
                        for (int i : luckyNum) {
                            System.out.print(i + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("运行查看中奖代码");
                    if (lotteries.length == 0 || luckyNum.length == 0) {
                        System.out.println("请购买并查看中奖号码后选择此功能");
                    } else {
                        int sum = 0;
                        for (int[] lottery : lotteries) {
                            int win = isWin(luckyNum, lottery);
                            sum += win;
                        }
                        System.out.println("共花费" + lotteries.length * 2 + "元，共获奖" + sum + "元");
                    }
                    break;
                case 5:
                    System.out.println("退出系统");
                    break o;
                default:
                    System.out.println("输入有误，请输入正确选项");
                    break;
            }
        }
    }

    // 判断是否中奖的方法
    // 输出彩票，盘端几等奖，输出并返回金额
    public static int isWin(int[] luckyNum, int[] lottery) {
        //判断前6位有几位相同
        int red = 0;
        for (int i = 0; i < 6; i++) {
            System.out.print(lottery[i] + "\t");
            if (luckyNum[i] == lottery[i])
                red++;
        }
        int blue = luckyNum[6] == lottery[6] ? 1 : 0;
        System.out.print("\t|\t" + lottery[6] + "\t");
        int money = 0;
        if (red == 6 && blue == 1) {
            money = 5000000;
            System.out.println("一等奖 " + money + "元");
        } else if (red == 6) {
            money = 1250000;
            System.out.println("二等奖 " + money + "元");
        } else if (red == 5 && blue == 1) {
            money = 3000;
            System.out.println("三等奖 " + money + "元");
        } else if (red == 5 || (red == 4 && blue == 1)) {
            money = 200;
            System.out.println("四等奖 " + money + "元");
        } else if (red == 4) {
            money = 10;
            System.out.println("五等奖 " + money + "元");
        } else if (red == 0 && blue == 1) {
            money = 5;
            System.out.println("六等奖 " + money + "元");
        } else {
            System.out.println("未中奖");
        }
        return money;
    }
}
