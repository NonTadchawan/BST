package org.example;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertKey(root, key);
    }

    private Node insertKey(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key) {
            node.left = insertKey(node.left, key);
        } else if (key > node.key) {
            node.right = insertKey(node.right, key);
        }
        return node;
    }

    public void delete(int key) {
        root = deleteKey(root, key);
    }

    private Node deleteKey(Node node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.key) {
            node.left = deleteKey(node.left, key);
        } else if (key > node.key) {
            node.right = deleteKey(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.key = minValue(node.right);
            node.right = deleteKey(node.right, node.key);
        }
        return node;
    }

    private int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            min = node.left.key;
            node = node.left;
        }
        return min;
    }

    void search() {
        searchByOder(root);
    }

    private void searchByOder(Node node) {
        if (node != null) {
            searchByOder(node.left);
            System.out.print(node.key + " ");
            searchByOder(node.right);
        }
    }

    public void searchByKey(int key) {
        searchKey(root, key);
    }

    private void searchKey(Node node, int key) {
        if (node == null) {
            System.out.println("Node not contain key: " + key);
        } else {
            if (key < node.key) {
                searchKey(node.left, key);
            } else if (key > node.key) {
                searchKey(node.right, key);
            }
            if (node.key == key) {
                System.out.println("Found node key: " + node.key);
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
