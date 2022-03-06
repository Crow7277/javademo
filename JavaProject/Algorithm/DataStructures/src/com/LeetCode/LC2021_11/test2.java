package com.LeetCode.LC2021_11;

public class test2 {
    public static void main(String[] args) {
        int n = 15;
        int e = 4;
        System.out.println(numWaterBottles(n, e));

    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles > numExchange) {
            int temp = numBottles % numExchange;
            numBottles /= numExchange;
            count += numBottles;
            numBottles += temp;
        }
        return count;
    }
}



