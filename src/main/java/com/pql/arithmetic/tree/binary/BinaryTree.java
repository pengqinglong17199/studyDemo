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

        return forInsert(root, t);
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

        Node<T> parentNode = node;
        Node<T> tempNode = node;
        int tempDirection = 0;

        while (tempNode != null){
            parentNode = tempNode;
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
            parentNode.left = new Node(t);
        } else {
            parentNode.right = new Node(t);
        }
        return true;
    }

    /**
     * 删除节点
     * @param t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 15:56
     */
    public boolean delete(T t){

        // 根节点不可为空
        if (root == null) {
            return true;
        }

        // 删除
        return delete(root, t);
    }

    /**
     * 删除节点 节点下的节点指定给父节点
     * 1. 如果左边有节点 将左节点提升为父节点
     * 2. 如果左边无节点,将右节点提升为父节点
     * @param t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 15:56
     */
    private boolean delete(Node<T> node, T t) {

        // 如果root匹配 直接删除root
        if (root.hash() == t.hash()) {
            Node<T> childNode = findChildNode(root);
            root = childNode;
            return true;
        }

        // 寻找该数据的父节点
        Node<T> parentNode = findParentNode(t);
        if(parentNode == null){
            return false;
        }

        // 正常删除节点
        if (parentNode.hash() > t.hash()) {
            Node<T> tempNode = findChildNode(parentNode.left);
            parentNode.left = tempNode;
        }else{
            Node<T> tempNode = findChildNode(parentNode.right);
            parentNode.right = tempNode;
        }

        return true;
    }

    /**
     *
     * 查找匹配对象的父节点 返回null代表root根节点匹配
     * @param t
     * @return Node
     * @author 彭清龙
     * @date 2020/10/26 22:00:24
     */
    private Node<T> findParentNode(T t) {

        Node<T> node = root;
        // root由外部校验 此处不考虑root匹配情况

        while (node != null){

            // 左节点不为空或者右节点不为空 并且能匹配上
            if((node.left != null && node.left.hash() == t.hash()) || (node.right != null && node.right.hash() == t.hash())){
                break;
            }

            // 当前节点的子节点都无法匹配上 寻找下一级子节点
            if (node.hash() > t.hash()) {
                node = node.left;
            }else {
                node = node.right;
            }
        }

        return node;
    }

    /**
     *
     * 获取子节点 优先获取左节点 左节点不存在则获取右节点 都不存在返回空
     * @param node
     * @return Node
     * @author 彭清龙
     * @date 2020/10/26 22:00:24
     */
    private Node<T> findChildNode(Node<T> node) {
        Node<T> tempNode;
        tempNode = node.left;
        if (node == null) {
            tempNode = node.right;
        }
        return tempNode;
    }

    public T find(T val){
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
