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
     * @param delNode
     * @return Node
     * @author 彭清龙
     * @date 2020/10/26 22:00:24
     */
    private boolean delNodeReplace(Node<T> delNode) {

        // 获取替换节点
        Node<T> replaceNode = findReplace(delNode);

        // 删除节点为子节点
        if(delNode.isChildNode()){

            if(root.hash() == delNode.hash()){
                root = null;
            }else if(delNode.parent.left != null && delNode.parent.left.hash() == delNode.hash()){
                delNode.parent.left = null;
            }else{
                delNode.parent.right = null;
            }

        }else if (delNode.isRoot()) {

            Node<T> temp = root;
            root = replaceNode;
            root.parent = null;
            // 看看替换节点的左/右 将其提升为root并将自己的右/左节点进行交付
            if (temp.hash() > replaceNode.hash()) {
                root.right = temp.right;
                root.right.parent = root;
            }else{
                root.left = temp.left;
                root.left.parent = root;
            }

        }else if(delNode.isLeft()){

            // 节点上升处理
            nodeRiseDispose(delNode, replaceNode);

            // 左节点上升
            delNode.parent.left = replaceNode;
            replaceNode.parent = delNode.parent;

        }else if(delNode.isRight()){

            // 节点上升处理
            nodeRiseDispose(delNode, replaceNode);

            // 右节点上升
            delNode.parent.right = replaceNode;
            replaceNode.parent = delNode.parent;

        }

        return true;
    }

    /**
     * 节点上升前的关联节点处理
     * @param delNode, replaceNode
     * @return void
     * @author 彭清龙
     * @date 2020/10/28 20:12
     */
    private void nodeRiseDispose(Node<T> delNode, Node<T> replaceNode) {
        // 替换节点角色是左节点
        if(replaceNode.isLeft()){

            // 替换节点是左节点时代表他没有右节点 将删除节点的右节点链接过来
            replaceNode.right = delNode.right;
            replaceNode.right.parent = replaceNode;

        }else if(replaceNode.isRight()){// 替换节点是右节点

            Node<T> right = replaceNode.right;
            Node<T> left = replaceNode.left;

            // 叶子节点处理
            if (replaceNode.isChildNode()) {
                // 无子节点的叶子节点直接继承删除节点的左右节点
                replaceNode.right = delNode.right;
                replaceNode.right.parent = replaceNode;

                replaceNode.left = delNode.left;
                replaceNode.left.parent = replaceNode;
            }

            // 替换节点左右节点是否饱满 如果不饱满 需要处理节点向上继承即可
            // 如果左右饱满 说明替换节点的选择满足了条件3 也就是删除节点左边无节点 无需处理子节点
            if(right == null || left == null){
                // 上升节点的子节点转为父节点连接
                Node<T> childNode = left;
                if(childNode == null){
                    childNode = right;
                }
                Node<T> replaceNodeParent = replaceNode.parent;
                replaceNodeParent.right = childNode;
                if(childNode != null){
                    childNode.parent = replaceNodeParent;
                }
            }


        }
    }

    private Node<T> findReplace(Node<T> delNode) {
        Node<T> replaceNode = delNode.left;
        // 1号条件
        if (replaceNode != null) {

            // 2号条件
            while (replaceNode.right != null){
                replaceNode = replaceNode.right;
            }
        }else{
            // 符合3号条件 在右节点进行解决
            replaceNode = delNode.right;
        }
        return replaceNode;
    }

    /**
     * 在二叉树中查询数据
     * @param val
     * @return T
     * @author 彭清龙
     * @date 2020/10/29 14:59
     */
    public T find(T val){
        Node<T> node = findNode(val);
        T t = null;
        if(node != null){
            t = node.val;
        }
        return t;
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

        /** 节点角色  根节点*/
        public static final int ROLE_ROOT = 0;
        /** 节点角色 左节点*/
        public static final int ROLE_LEFT = 1;
        /** 节点角色 右节点*/
        public static final int ROLE_RIGHT = 2;


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

        /**
         * 判断节点是否是叶子节点
         * @return boolean
         * @author 彭清龙
         * @date 2020/10/28 17:28
         */
        public boolean isChildNode(){
            return left == null & right == null;
        }

        /**
         * 是否是根节点
         * @return boolean
         * @author 彭清龙
         * @date 2020/10/28 20:15
         */
        public boolean isRoot(){
            return parent == null;
        }

        /**
         * 是否是左节点
         * @return boolean
         * @author 彭清龙
         * @date 2020/10/28 20:14
         */
        public boolean isLeft(){
            return parent != null && this.equals(parent.left);
        }

        /**
         * 是否右节点
         * @return boolean
         * @author 彭清龙
         * @date 2020/10/28 20:14
         */
        public boolean isRight(){
            return parent != null && this.equals(parent.right);
        }

        /**
         * 获取节点角色
         * @return int 0: 无父节点 1: 属于父节点的左节点 2: 属于父节点的右节点
         * @author 彭清龙
         * @date 2020/10/28 17:28
         */
        public int getRole(){
            if(parent != null){
                return this.equals(parent.left) ? ROLE_LEFT : ROLE_RIGHT;
            }
            return ROLE_ROOT;
        }

        @Override
        public String toString(){

            return val.hash()+"";
        }
    }
}
