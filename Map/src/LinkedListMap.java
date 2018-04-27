import java.util.ArrayList;

/**
 * @author Ji YongGuang.
 * @date 15:23 2018/4/26.
 * 基于链表实现的映射
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node<K, V> {

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    public Node dummyHead;
    public int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 查找当前链表映射中有无key 对应的节点
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            // 这里判断的是节点的key 而不是value
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            // 赋予新值
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        if (getNode(key) == null) {
            return null;
        }

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node target = prev.next;
            prev.next = target.next;
            target.next = null;
            size--;
            return (V) target.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : (V) node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        // 所有词存入words
        if (FileOperation.readFile("E:\\IntelliJ IDEA " +
                "2017.1Projects\\PlayWithDataStructures\\Map\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
            for (String word : words) {
                if (linkedListMap.contains(word)) {
                    linkedListMap.set(word, linkedListMap.get(word) + 1);
                } else {
                    linkedListMap.add(word, 1);
                }
            }

            System.out.println("所有不同的单词数量: " + linkedListMap.size);
            System.out.println("pride 单词出现的次数" + linkedListMap.get("pride"));
            System.out.println("Prejudice 单词出现的次数" + linkedListMap.get("prejudice"));
        }
    }
}
