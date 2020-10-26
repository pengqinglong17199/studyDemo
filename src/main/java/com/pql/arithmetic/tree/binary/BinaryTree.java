package com.pql.arithmetic.tree.binary;

import lombok.Data;

/**
 * 二叉树实现类
 * @author 彭清龙
 * @date 2020/10/19 15:14
 */
public class BinaryTree<T extends Sort> {
    /**
     * 思路：
     *  1. 二叉树 根节点往下衍生
     *  2. 每个节点最多拥有两个子节点 左子节点比自己小 右子节点比自己大
     *  3. 节点使用内部类node 通过泛型进行对象兼容 提供一个接口给对象实现 获取比对值
     *  4. 内部类node 需要一个成员变量保存对象 需要左节点和右节点两个成员变量
     *  5. 实现类需要持有根节点 才方便往下衍生，所以实习类增加一个成员变量持有根节点
     *  开始
     */

    /** 左节点*/
    private static final int left = 1;
    /** 右节点*/
    private static final int right = 2;

    /** 持有根节点*/
    private Node<T> root;

    /**
     * 插入方法
     * @param t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 15:47
     */
    public boolean insert(T t){

        // 赋值根节点
        if(root == null){
            root = new Node(t);
            return true;
        }

        return recursionInsert(root, t);
    }

    /**
     * 递归业务插入节点 逻辑清晰 存在问题 如果树的深度过深 会导致栈溢出
     * @param node, t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 15:56
     */
    private boolean recursionInsert(Node node, T t){

        Node<T> tempNode;
        int tempDirection;

        // 值小于根节点 为左节点
        if (t.hash() < node.hash()) {
            tempNode = node.left;
            tempDirection = left;
        }else{ // 否则为右节点
            tempNode = node.right;
            tempDirection = right;
        }

        // 校验子节点是否存在
        if(tempNode == null){
            if (tempDirection == left) {
                node.left = new Node(t);
            }else{
                node.right = new Node(t);
            }
            return true;
        }

        return recursionInsert(tempNode, t);
    }

    /**
     * 循环业务插入节点
     * @param node, t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 16:54
     */
    private boolean forInsert(Node node, T t){

        Node<T> tempNode = node;
        int tempDirection = 0;

        while (tempNode != null){

            // 值小于根节点 为左节点
            if (t.hash() < tempNode.hash()) {
                tempNode = tempNode.left;
                tempDirection = left;
            } else { // 否则为右节点
                tempNode = tempNode.right;
                tempDirection = right;
            }
        };

        if (tempDirection == left) {
            tempNode.left = new Node(t);
        } else {
            tempNode.right = new Node(t);
        }
        return true;
    }


    public boolean delete(T t){
        return true;
    }

    public T find(int val){
        return null;
    }

    public void pint(T t){

    }
    /**
     * 节点内部类
     * @author 彭清龙
     * @date 2020/10/19 15:35
     */
    @Data
    private class Node<T extends Sort>{

        private Node<T> left;
        private T val;
        private Node<T> right;

        public Node(T t){
            val = t;
        }

        public int hash(){
            return val.hash();
        }
    }
}
