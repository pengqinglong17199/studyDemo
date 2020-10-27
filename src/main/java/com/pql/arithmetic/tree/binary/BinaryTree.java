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
            root = new Node(t, null);
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
                node.left = new Node(t, node);
            }else{
                node.right = new Node(t, node);
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
            parentNode.left = new Node(t, parentNode);
        } else {
            parentNode.right = new Node(t, parentNode);
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
     * @param t
     * @return boolean
     * @author 彭清龙
     * @date 2020/10/19 15:56
     */
    private boolean delete(Node<T> node, T t) {

        // 寻找需要删除的数据节点
        Node<T> findNode = findNode(t);
        if(findNode == null){
            return false;
        }

        // 删除节点进行子节点替换
        return delNodeReplace(findNode);
    }

    /**
     *
     * 查找匹配对象的节点 查不到则为null
     * @param t
     * @return Node
     * @author 彭清龙
     * @date 2020/10/26 22:00:24
     */
    private Node<T> findNode(T t) {

        Node<T> node = root;

        while (node != null){
            if (node.hash() > t.hash()) {
                node = node.left;
            } else if(node.hash() < t.hash()) {
                node = node.right;
            } else{
                break;
            }
        }

        return node;
    }

    /**
     * 获取需要删除的节点
     * 1. 如果左边有节点 将左节点提升为当前节点
     * 2. 如果左节点还存在子右节点，寻找到最底层得最右节点
     * 3. 如果左边无节点,将右节点提升为父节点
     * @param node
     * @return Node
     * @author 彭清龙
     * @date 2020/10/26 22:00:24
     */
    private boolean delNodeReplace(Node<T> node) {
        Node<T> tempNode;
        tempNode = node.left;

        // 1号条件
        if (tempNode != null) {

            // 2号条件
            while (tempNode.right != null){
                tempNode = tempNode.right;
            }
        }else{
            // 符合3号条件
            tempNode = node.right;
        }

        // 子节点修改父节点为爷节点
        tempNode.parent = node.parent;

        // root节点特殊判断
        if(root.hash() == node.hash()){
            root = tempNode;
        }else if (node.parent.left.hash() == node.hash()) {
            // 子节点覆盖父节点
            node.parent.left = tempNode;
        }else{
            node.parent.right = tempNode;
        }
        return true;
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
        private Node<T> parent;

        public Node(T t, Node<T> parent){
            this.val = t;
            this.parent = parent;
        }

        public int hash(){
            return val.hash();
        }
    }
}
