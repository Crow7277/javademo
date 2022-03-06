package com.crow.encapsulation2;

/**
 * User crow7
 * Date 2021/9/5.
 */

/**
 * 封装练习
 * 编写自定义秒回图书信息
 * 属性：书名，作者，出版社名，价格
 * 方法：信息介绍
 * 要求：
 * 1.设置属性的私有访问权限，通过共有的get，set方法实现对属性的访问
 * 2.限定价格必须大于10，如无效进行提示
 * 3.设计构造方法实现对属性赋值
 * 4.信息介绍方法描述图书所有信息
 * 5。编写测试类，册数图书类的对象及相关方法
 */
public class Book {
    private String bookName;    //图书名称
    private String author;      //作者
    private String publisher;   //出版社
    private double price;       //价格

    /**
     * 无参数构造方法
     */
    public Book() {
    }

    /**
     * 有参数构造方法
     * 给书本信息赋值
     *
     * @param bookName  书名
     * @param author    作者
     * @param publisher 出版社
     * @param price     价格
     */
    public Book(String bookName, String author, String publisher, double price) {
        // TODO: 2021/9/5
        this.setAuthor(author);
        this.setBookName(bookName);
        this.setPrice(price);
        this.setPublisher(publisher);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(double price) {
        if (price < 10.0) {
            System.out.println("输入的价格过低");
        } else {
            this.price = price;
        }
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void show(){
        System.out.println("书名："+getBookName()+
                "\n作者："+getAuthor()+
                "\n出版社："+getPublisher()+
                "\n价钱："+getPrice()+"元");
    }

    public static void main(String[] args) {
        Book book = new Book("钢铁是怎么炼成的","尼古拉·奥斯特洛夫斯基","人民教育出版社",23.5);
        book.show();
    }
}
