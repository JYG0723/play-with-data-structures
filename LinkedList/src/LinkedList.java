/**
 * @author Ji YongGuang.
 * @date 9:20 2018/4/19.
 */
public class LinkedList<E> {

    /**
     * 虚拟头结点
     */
    private Node dummyHead;
    /**
     * 链表元素个数
     */
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    private class Node {
        public E e;
        public Node next;

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

    /**
     * 获取链表的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断当前链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node pre = dummyHead;
        // 找到节点插入位置的前驱节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 在链表头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        // size 是方便add函数找到新插入节点的前驱节点
        add(size, e);
    }

    /**
     * 获取链表第index个位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @return
     */
    public boolean contain(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        /*Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur);
            res.append("->");
        }*/
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }

    /**
     * 从链表中删除index索引位置的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node removeNode = prev.next;
        prev.next = removeNode.next;
        removeNode.next = null;
        size--;

        return removeNode.e;
    }

    /**
     * 删除链表的第一个节点，并返回节点
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表的最后一个节点，并返回节点
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }
}
