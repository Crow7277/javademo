package com.crow.oop3;

/**
 * User crow7
 * Date 2021/9/4.
 */
public class Computer {
    //成员变量
    private String cpu;
    private String mainBoard;
    private String memory;
    private String keyboard;

    public Computer() {
        System.out.println("==============Computer===================");
    }

    //    public Computer(String cpu1,String mainBoard1,String memory1, String keyboard1){
//        cpu = cpu1;
//        mainBoard = mainBoard1;
//        memory=memory1;
//        keyboard=keyboard1;
//    }
    public Computer(String cpu, String mainBoard, String memory, String keyboard) {
        this.cpu = cpu;
        this.mainBoard = mainBoard;
        this.memory = memory;
        this.keyboard = keyboard;
    }

    //成员方法
    public void start() {
        System.out.println("----------starting----------");
    }

    public void stop() {
        System.out.println("----------stopping----------");
    }

    public void show() {
        System.out.println(
                "cpu：" + cpu +
                        "\nmainBoard：" + mainBoard +
                        "\nmemory：" + memory +
                        "\nkeyboard：" + keyboard
        );
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.cpu = "Intel";
        computer.mainBoard = "华硕";
        computer.memory = "金士顿";
        computer.keyboard = "雷蛇";

        computer.start();
        computer.show();
        computer.stop();

        Computer computer2 = new Computer("Intel", "华硕", "金士顿", "雷蛇");

    }
}
