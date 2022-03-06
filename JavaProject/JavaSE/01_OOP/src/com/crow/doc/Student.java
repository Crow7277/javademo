package com.crow.doc;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Student {
    /**
     * 学号
     */
    private int sno;
    /**
     * 姓名
     */
    String name;
    /**
     * 分数
     */
    public double score;

    /**
     * 无参数构造方法
     */
    public Student() {
    }

    /**
     * 有参数构造方法
     *
     * @param sno   学号
     * @param name  姓名
     * @param score 分数
     */
    public Student(int sno, String name, double score) {
        this.name = name;
        this.sno = sno;
        this.score = score;
    }

    /**
     * 学习
     */
    public void study() {
    }

    /**
     * 考试
     *
     * @param site 地点
     * @return 分数
     */
    public double test(String site) {
        return 100.0;
    }
}
