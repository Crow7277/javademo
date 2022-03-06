package com.LeetCode.LC2021_11;

/**
 * User crow7
 * Date 2021/11/20.
 */
public class test1 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 2) {
            i++;
        }
        System.out.println(i);
    }
}


class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        /**
         总时间:minutesToTest
         死亡时间:minutesToDie
         桶数量:buckets
         pow(x,y):x的y次方
         ceil(x):向上取整

         当小猪数量为1时，总时间为60分钟，死亡时间为15分钟时，可以喝4次
         1.小猪喝下第1桶水，等待十五分钟，死亡->毒在1中
         2.小猪喝下第2桶水，等待十五分钟，死亡->毒在2中
         3.小猪喝下第3桶水，等待十五分钟，死亡->毒在3中
         4.小猪喝下第4桶水，等待十五分钟，死亡->毒在4中
         存活->毒在5中

         由上面的信息可以得到，一只猪，可以验证5桶水，也就是buckets <= 5 answer = 1
         此时，相当于，这只猪都可以得到5个信息量base，这5个信息量计算为 总时间/死亡时间 + 1
         总时间/死亡时间为一只小猪可以喝的水量，根据上面的信息，为4桶，
         此时由于已经判断了4桶，所以如果只有五桶水的话，第五桶的信息也可以判断出来，所以信息量为5

         因此，如果有两只猪，就可以获得pow(base,2) = 5^2 = 25种信息也就是5 <= buckets <=25 answer = 2
         因此可以得到buckets <= pow(base,answer)，取log可以得到 anser >= log(buckets)/log(base)
         由于ans为正数，所以此时应该向上取整,ans = ceil(ans) = ceil(log(buckets)/log(base))
         */
        int ans;//小猪的数量
        int base = minutesToTest / minutesToDie + 1;//信息量
        ans = (int) Math.ceil(Math.log(buckets) / Math.log(base));
        return ans;
    }
}





