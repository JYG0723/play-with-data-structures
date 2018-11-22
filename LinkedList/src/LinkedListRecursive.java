import javafx.util.Pair;

/**
 * @author Ji YongGuang.
 * @date 17:44 2018/11/22.
 * @description
 */
public class LinkedListRecursive<E> {

    private static class Node<E> {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 在链表的递归实现中，我们不使用虚拟头结点，也能无差异的处理位置0的问题：）
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        head = add(head, index, e);
        size++;
    }

    // node 节点的index位置插入元素e
    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }
        // node 子链表拿去使用
        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        return get(head, index);
    }

    public void set(int index, E e) {
        set(head, index, e);
    }

    // 设置以node为头结点的链表的index索引处的节点值为e
    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        // 设置node节点的子链表
        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    // 查看以头节点为node的链表中是否有节点为e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        // 查看node的子链表的节点是否包含元素e
        return contains(node.next, e);
    }

    // 查找以node节点为首的链表的第index个元素
    public E get(Node node, int index) {
        if (index == 0) {
            return (E) node.e;
        }
        return get(node.next, index - 1);
    }

    // 仅删除第一个值为e的节点
    public E remove(int index) {
        // Pair 包含的是以head为头结点的链表删除值为e的节点后的子链表。及删除元素e
        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    // 删除以node为头结点的链表中索引为index的节点
    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<Node, E>(node.next, (E) node.e);
        }
        // node子链表的删除结果
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    // 从链表中删除元素e
    // 只删匹配的第一个
    public void removeElement(E e) {
        // 很可能头结点就是元素e,所以头结点可能更改
        head = removeElement(head, e);
    }

    // 从以node为头节点的链表中删除元素e
    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.equals(e)) {
            return node.next;
        }
        // node的子链表删除成功
        node.next = removeElement(node.next, e);
        return node;
    }
}
