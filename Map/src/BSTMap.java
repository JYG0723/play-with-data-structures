import java.util.ArrayList;

/**
 * @author Ji YongGuang.
 * @date 18:22 2018/4/26.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {

        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node root;
    public int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * 向映射中有序的添加一个元素
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向映射中有序的添加一个元素(key,value) 真正处理逻辑
     *
     * @param root
     * @param key
     * @param value
     */
    private Node add(Node root, K key, V value) {

        if (root == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = add(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = add(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }

    @Override
    public V remove(K key) {
        if (getNode(root, key) != null) {
            return remove(root, key).value;
        }
        return null;
    }

    private Node remove(Node root, K key) {

        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            root.right = remove(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size--;
                return rightNode;
            }
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size--;
                return leftNode;
            }
            // 左右子树均不为空
            Node successor = minimum(root.right);
            // 这一步只是把successor提上来了。并没有真正删除，但是函数中size确实-1了。
            successor.right = removeMin(root.right);
            successor.left = root.left;

            // 释放 root 节点左右指针变量
            // 预删除 root 节点。由于前面removeMin函数已经-1过了。所以不需要再-1了。
            root.left = root.right = null;

            // 右子树被删的节点的新右子树1
            // root 节点被真实删除
            return successor;
        }
    }

    private Node minimum(Node root) {

        if (root == null) {
            throw new IllegalArgumentException("The Tree is Empty!");
        }

        if (root.left == null) {
            return root;
        }

        return minimum(root.left);
    }

    private Node removeMin(Node root) {

        if (root.left == null) {
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }

        // 新左子树
        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     *
     * @param root
     * @param key
     * @return
     */
    private Node getNode(Node root, K key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) < 0) {
            return getNode(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            return getNode(root.right, key);
        } else {
            return root;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node target = getNode(root, key);
        return target == null ? null : target.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node target = getNode(root, key);
        if (target == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        target.value = newValue;
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

            BSTMap<String, Integer> bstMap = new BSTMap<>();
            for (String word : words) {
                if (bstMap.contains(word)) {
                    bstMap.set(word, bstMap.get(word) + 1);
                } else {
                    bstMap.add(word, 1);
                }
            }

            System.out.println("所有不同的单词数量: " + bstMap.size);
            System.out.println("pride 单词出现的次数" + bstMap.get("pride"));
            System.out.println("Prejudice 单词出现的次数" + bstMap.get("prejudice"));
        }
    }
}
