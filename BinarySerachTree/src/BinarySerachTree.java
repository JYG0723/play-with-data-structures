import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ji YongGuang.
 * @date 17:48 2018/4/20.
 * 二叉搜索树
 */
public class BinarySerachTree<E extends Comparable<E>> {

    public Node root;
    public int size;

    public BinarySerachTree() {
        root = null;
        size = 0;
    }

    private class Node {

        public E value;
        public Node left, right;

        public Node(E e) {
            this.value = e;
            left = null;
            right = null;
        }
    }

    /**
     * 返回二叉搜索树节点个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 是否为空的二叉树
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二叉搜索树中有序的添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向二叉搜索树中有序的添加一个元素 真正处理逻辑
     *
     * @param root
     * @param e
     */
    private Node add(Node root, E e) {

        /*if (root.value.compareTo(e) == 0) {
            return;
        } else if (root.value.compareTo(e) < 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        } else if (root.value.compareTo(e) > 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e) < 0)
            add(node.left, e);
        else //e.compareTo(node.e) > 0
            add(node.right, e);
        */

        if (root == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(root.value) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.value) > 0) {
            root.right = add(root.right, e);
        }

        return root;
    }

    /**
     * 二叉搜索树中是否包含某一个元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断二叉树中是否包含某一元素e 的真正处理逻辑
     *
     * @param root
     * @param e
     * @return
     */
    private boolean contains(Node root, E e) {

        if (root == null) {
            return false;
        }

        if (e.compareTo(root.value) < 0) {
            return contains(root.left, e);
        } else if (e.compareTo(root.value) > 0) {
            return contains(root.right, e);
        } else {
            return true;
        }
    }

    /**
     * 前序遍历当前树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 树 前序遍历的非递归实现
     */
    public void preOrderNonR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            // 入栈顺序 先右后左 才能保证在遍历输出栈中节点的时候 先出来的是前一节点的左孩子。否则出来的是右孩子
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param root
     * @param depth
     * @param res
     */
    private void generateBSTString(Node root, int depth, StringBuilder res) {

        if (root == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + root.value);
        generateBSTString(root.left, depth + 1, res);
        generateBSTString(root.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    /**
     * 二叉搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 树 中序遍历的递归实现
     *
     * @param root
     */
    private void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 二叉搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 树 后序遍历的递归实现
     *
     * @param root
     */
    private void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    /**
     * 层序遍历当前树
     */
    public void levelOrder() {
        levelOrder(root);
    }

    /**
     * 层序遍历当前树
     *
     * @param root
     */
    private void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找当前搜索二叉树的最小值e
     *
     * @return
     */
    public E minimum() {
        return minimum(root).value;
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

    /**
     * 寻找当前搜索二叉树的最大值e
     *
     * @return
     */
    public E maximum() {
        return minimum(root).value;
    }

    private Node maximum(Node root) {

        if (root == null) {
            throw new IllegalArgumentException("The Tree is Empty!");
        }

        if (root.right == null) {
            return root;
        }

        return minimum(root.right);
    }

    /**
     * 删除当前搜索二叉树的最小值e
     *
     * @return
     */
    public E removeMin() {
        E e = minimum();
        // 必须指定，有可能该树除了自身 只有右子树一个节点
        root = removeMin(root);
        return e;
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
     * 删除当前搜索二叉树的最大值e
     *
     * @return
     */
    public E removeMax() {
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node root) {

        if (root.right == null) {
            Node rightNode = root.left;
            root.left = null;
            size--;
            return rightNode;
        }

        // 新右子树
        root.right = removeMin(root.right);
        return root;
    }


    /**
     * 删除二叉搜索树元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node root, E e) {

        if (root == null) {
            return null;
        }

        if (e.compareTo(root.value) < 0) {
            root.left = remove(root.left, e);
            return root;
        } else if (e.compareTo(root.value) > 0) {
            root.right = remove(root.right, e);
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
}
