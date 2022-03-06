package com.crow.huffmancode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * User crow7
 * Date 2021/11/22.
 */
public class HuffMenCode {
    public static void main(String[] args) {
        //测试压缩文件
        String srcFile = "d:\\test\\新建文本文档.txt";
        String dstFile = "d:\\test\\dst.zip";
        zipFile(srcFile, dstFile);
        System.out.println("压缩完成");

        //测试解压文件
        String dstFile1 = "d:\\test\\src2.txt";
        String zipFile = "d:\\test\\dst.zip";
        unZipFile(zipFile, dstFile1);
        System.out.println("解压完成");
        String str = "i like like like java do you like a java";
        byte[] contentByte = str.getBytes();
        byte[] huffmanCodeBytes = huffmanZip(contentByte);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        System.out.println("len = " + huffmanCodeBytes.length);

        //测试byteTobitString方法
        byte[] sourceBytes = decode(huffmanCodes,huffmanCodeBytes);
        System.out.println(new String(sourceBytes));

    }
    //编写一个方法完成对压缩文件的解压

    /**
     * 文件解压
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 解压的路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        //定义文件的输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义一个文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的文件输入流
            ois = new ObjectInputStream(is);
            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取霍夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            //将bytes写入到目标文件
            os = new FileOutputStream(dstFile);
            //写出数据到文件中
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //编写一个方法对一个文件进行压缩

    /**
     * 对文件进行压缩
     *
     * @param srcFile  传入希望压缩文件的全路径
     * @param destFile 压缩后的文件放入到的目录
     */
    public static void zipFile(String srcFile, String destFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建一个文件的输入流，读取文件
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte数组
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件进行压缩
            byte[] huffmanByts = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os = new FileOutputStream(destFile);
            //创建一个和问价输出流相关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把霍夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanByts);
            //以对象流的方式写入霍夫曼编码，是为了以后恢复原文件时使用
            //一定要把霍夫曼编码写入压缩文件，否则无法回复
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    /**
     * 封装霍夫曼编码压缩
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过霍夫曼编码处理后的字节数组，也就是压缩后的数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建霍夫曼树
        Node huffmanTree = creatHuffmanTree(nodes);
        //生成对应的霍夫曼编码（根据霍夫曼树创建霍夫曼编码）
        getCodes(huffmanTree);
        //根据身材的霍夫曼编码压缩得到压缩后的霍夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    //完成数据的解压
    /*思路：
    1.将huffmenCodebytes[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
        重新转成霍夫曼编码的对应的二进制字符串
    2.霍夫曼编码对应的二进制的字符串转换成最初的字符串i like like like java do you like a java
    */

    /**
     * 将一个byte转成一个二进制的字符串
     *
     * @param b    传入的byte
     * @param flag 表示是否需要补高位，如果是true，表示需要补，如果是false表示不补
     * @return 该byte对应的二进制字符串，是按照补码返回的
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b;
        if (flag) {
            //如果是正数，由于正数的源码和补码相等，所以只会出现一位，因此需要补位
            temp |= 256;//按位与，256 => 1 0000 0000 | 0000 00001 = 1 0000 0001
        }
        String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制的补码
        if (flag) {
            //取后面的八位
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }
    //编写一个方法完成对压缩数据的解码

    /**
     * 对压缩数据的解码
     *
     * @param huffmanCodes 霍夫曼编码表 map
     * @param huffmanBytes 霍夫曼编码得到的字节数组
     * @return 原来字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1.先得到huffmanBytes对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是否是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串按照指定的霍夫曼编码进行解码
        //把霍夫曼编码表进行调换，因为要反向查询
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;//小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出一个1或者0
                String key = stringBuilder.substring(i, i + count);//i不动，count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null) {//说明没有匹配到
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后,list中存放了所有的字符
        //把list总的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    /**
     * @param bytes 接收字节数组
     * @return 返回一个List
     */
    private static List<Node> getNodes(byte[] bytes) {
        //1.创建一个ArrayList
        List<Node> nodes = new ArrayList<Node>();
        //遍历Byte，统计每个byte出现的次数,使用哈希表
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
            /*
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }*/
        }
        //把每一个键值对转换成一个Node对象并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过List创建霍夫曼树
    private static Node creatHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);
            //取出第一棵最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二棵最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一个新的二叉树，他的根结点没有data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将处理过的二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入nodes
            nodes.add(parent);
        }
        //返回最后的结点就是霍夫曼树的根结点
        return nodes.get(0);
    }

    //前序遍历
    public static void preOrder(Node root) {
        if (root == null) {
            System.out.println("为空无法遍历");
        } else {
            root.preOrder();
        }
    }

    //生成霍夫曼树对应的霍夫曼编码
    //1. 将霍夫曼编码表存放在一个HashMap中，Map<Byte,String>
    //形式为：32->01 97->100 100->11000
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2.在生成霍夫曼编码表时，需要去拼接路径，定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.left, "0", stringBuilder);
        //处理右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的霍夫曼编码得到，并放入存放到huffmanCode集合中
     *
     * @param node          传入的结点
     * @param code          路径，左子结点为0，右子结点为1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到StringBuilder2中
        stringBuilder2.append(code);
        //如果node == null不处理
        if (node != null) {
            //判断当前node是叶子结点还是非叶子结点
            if (node.data == null) {
                //此时为非叶子结点，递归处理
                //向左递归，左子结点为0
                getCodes(node.left, "0", stringBuilder2);
                //向右递归，右子结点为1
                getCodes(node.right, "1", stringBuilder2);
            } else {
                //说明是一个叶子结点
                //说明找到了某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //编写一个方法，将字符串对应的byte数组通过生成的霍夫曼编码表生成返回一个霍夫曼编码表处理过后的byte数组

    /**
     * 将字符串对应的byte数组通过生成的霍夫曼编码表生成返回一个霍夫曼编码表处理过后的byte数组
     *
     * @param bytes        原始字符串对应的byte[]
     * @param huffmanCodes 生成的霍夫曼编码map
     * @return 霍夫曼编码处理后的byte[], 由于霍夫曼编码生成的是二进制字符串，因此会变成8位一个byte的数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用霍夫曼编码表将传进来的byte转成霍夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历byte数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //2.将字符串转换为byte数组
        //计算要转换的byte数组的长度
        int len;
        //len = (stringBuilder.length() + 7) / 8;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建压缩后的byte的数组
        byte[] huffmanCodeBytes = new byte[len];
        //因为一个byte是8bit，所以步长为8
        int index = 0;//huffmanCodeBytes[]索引
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                //说明剩下的长度不满足八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte转换成一个byte放入huffmanCodeBytes中
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
}


//创建Node，带数据和权值
class Node implements Comparable<Node> {
    Byte data;//存放数据本身，如 a，存储时存储为ASCII码
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //按照权值从小到大排列
        return this.weight - o.weight;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
