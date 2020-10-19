package com.pql.arithmetic.tree.binary;


/**
 * 二叉树main方法
 * @author 彭清龙
 * @date 2020/10/19 15:13
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree<Worker> tree = new BinaryTree();


        tree.insert(new Worker(10,"郭小瑾", 18, "女"));
        tree.insert(new Worker(5,"彭清龙", 20, "男"));
        tree.insert(new Worker(15,"郑凯琳", 25, "男"));
        tree.insert(new Worker(15,"曾德宇", 30, "男"));
        tree.insert(new Worker(14,"高一帆", 35, "男"));
        tree.insert(new Worker(13,"董伟", 40, "男"));
        tree.insert(new Worker(14,"方健辉", 44, "男"));
        tree.insert(new Worker(15,"罗静茹", 58, "女"));
        System.out.println(true);
    }
}
