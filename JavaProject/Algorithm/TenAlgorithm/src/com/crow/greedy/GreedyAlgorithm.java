package com.crow.greedy;

import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入到HashMap中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts中
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        //创建一个ArrayList存放选择的电台集合
        Set<String> selects = new HashSet<String>();
        //定义一个临时的集合，在遍历的过程中存放遍历过程中电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> temp = new HashSet<>();
        //定义一个maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖的区域对应的电台的key
        String maxKey = null;
        int maxKeyCoverNum = 0;
        //如果maxKey不为空，则会加入到selects
        while (!allAreas.isEmpty()) {//如果allAreas不为0，则说明还没有覆盖到所有的地区
            //遍历broadcast，取出对应的key
            for (String key : broadcasts.keySet()) {
                HashSet<String> areas = broadcasts.get(key);
                temp.addAll(areas);
                //求出tempSet和areas结合的交集，这个交集会赋给tempSet
                temp.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量比maxKey指向的集合未覆盖的地区还多
                //需要充值maxKey
                //tempSet.size() > broadcasts.get(maxKey).size()体现出贪心算法的特点
                if (temp.size() > 0 && temp.size() > maxKeyCoverNum) {
                    maxKey = key;
                    maxKeyCoverNum = temp.size();
                }
                temp.clear();
            }
            if (maxKey == null) continue;
            // 循环完成后，找到了本轮的 maxKey
            // 添加到已选择列表中，并且从 未覆盖列表 中删除已经覆盖过的地区
            selects.add(maxKey);
            allAreas.removeAll(broadcasts.get(maxKey));
            // 清空临时变量，方便下次查找
            maxKey = null;
            maxKeyCoverNum = 0;
        }
        System.out.println("得到的选择结果是：" + selects);
    }
}
