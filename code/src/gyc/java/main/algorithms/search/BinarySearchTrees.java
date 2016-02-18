package gyc.java.main.algorithms.search;


/**
 * 使用一个二叉树来做一个序列表
 * @author guoyc on 16-1-15.
 */
public class BinarySearchTrees<K extends Comparable<K>, V> {

    private Node root;

    // 键值必须是可比较的
    private class Node{
        private K key;
        private V value;
        private Node leftNode;
        private Node rightNode;
        private int count; // 该节点的子树中的节点总数

        public Node(K k, V v, int count) {
            this.key = k;
            this.value = v;
            this.count = count;
        }

    }

    // 获取某个值
    public V get(K k) {
        return get(root, k);
    }

    // 从根节点开始遍历,获取根节点的值
    private V get(Node node, K k) {
        if (node.key.compareTo(k) == 0) {
            return node.value;
        } else if (node.key.compareTo(k) < 0) {
            return node.leftNode == null ? null : get(node.leftNode, k);
        } else {
            return node.rightNode == null ? null : get(node.rightNode, k);
        }
    }

    public void put(K k, V v) {
        root = put(root, k, v);
    }

    private Node put(Node node, K k, V v) {
        if (node == null) {
            return new Node(k, v, 0);
        }
        if (node.key.compareTo(k) == 0) {
            node.value = v;
            return node;
        } else if (node.key.compareTo(k) < 0) {
            node.leftNode = put(node.leftNode, k, v);
        } else {
            node.rightNode = put(node.rightNode, k, v);
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTrees<Integer, String> binarySearchTrees = new BinarySearchTrees<>();
        binarySearchTrees.put(1, "a");
        binarySearchTrees.put(2, "c");
        binarySearchTrees.put(3, "b");
        binarySearchTrees.put(4, "r");
        System.out.print(binarySearchTrees.get(4));
    }
}
