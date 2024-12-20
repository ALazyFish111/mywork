package com.example.work.config;

public class MyLinkedList<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;  //空头
    private int size;

    public MyLinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 增加一个节点
     * 增加一个头节点
     * 增加一个尾节点
     * 在指定下标增加
     */

    /**
     * 在指定下标添加一个元素
     *
     * 时间复杂度：若在头部插入元素复杂度O(1), 队尾O(n)  平均时间复杂度O(n/2)
     * 而渐进时间复杂度的n趋近去无穷  所以在指定下标添加一个元素的时间复杂度为O(n)
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        //考虑边界问题
        //下标不合法  index < 0 || index >size
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下标不合法！");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 链表首添加一个节点
     * 时间复杂度: O(1)
     */

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表尾添加一个节点
     * 时间复杂度: O(n)
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     *删除一个节点
     * 删除头节点
     * 删除尾节点
     * 删除指定下标节点
     */

    /**
     * 删除指定下标的节点
     *
     * 时间复杂度:O(n)
     * @param index
     * @return
     */
    public E remove(int index) {
        //考虑边界问题
        //下标不合法  index < 0 || index >size
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("下标不合法！");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node ret = pre.next;
        pre.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    /**
     * 删除头节点
     *
     * 时间复杂度:O(1)
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾节点
     *
     * 时间复杂度:O(n)
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查询一个节点
     * 查询头节点
     * 查询尾节点
     * 查询指定下标的节点
     */

    /**
     * 获取指定下标的元素
     *
     * 时间复杂度:O(n)
     * @param index
     * @return
     */
    public E get(int index) {
        //考虑边界问题
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("下标不合法！");
        }

        Node retn = dummyHead.next;
        for (int i = 0; i < index; i++) {
            retn = retn.next;
        }
        return retn.e;
    }

    /**
     * 获取头节点
     *
     * 时间复杂度:O(1)
     * @return
     */
    public E getFirst() {
        return this.get(0);
    }

    /**
     * 获取尾节点
     *
     * 时间复杂度:O(n)
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 更新一个节点
     * 更新头节点
     * 更新尾节点
     * 更新指定下标的节点
     */


    /**
     * 更新指定下标的节点
     *
     * 时间复杂度:O(n)
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        //考虑边界问题
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("下标不合法！");
        }
        Node retn = dummyHead.next;
        for (int i = 0; i < index; i++) {
            retn = retn.next;
        }
        retn.e = e;
    }

    /**
     * 更新头节点
     *
     * 时间复杂度:O(1)
     * @param e
     */
    public void setFirst(E e) {
        this.set(0, e);
    }

    /**
     * 更新尾节点
     *
     * 时间复杂度:O(n)
     * @param e
     */
    public void setLast(E e) {
        this.set(size - 1, e);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

}