package org.example;

import javax.swing.*;
import java.awt.*;

public class BinaryTreeCanvas extends JLabel {
    Node root;
    int key;
    int yGap = 150;
    int r = 30;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.LIGHT_GRAY);
        Dimension size = getSize();
        graphics2D.fillRect(0, 0, size.width, size.height);
        drawTree(graphics2D, root, 750, 100, 350);
        graphics2D.dispose();
    }

    void drawTree(Graphics2D g, Node root, int x, int y, int xGap) {
        if (root != null) {
            if (root.key != null) {
                g.setColor(Color.PINK);
                g.fillOval(x - r, y - r, 2 * r, 2 * r);
                g.setColor(Color.white);
                g.drawString(root.key.toString(), x - 5, y + 5);
            }
            if (root.left != null) {
                drawLineLeft(g, x - xGap, y + yGap, x, y);
                drawTree(g, root.left, x - xGap, y + yGap, xGap / 2);
            }
            if (root.right != null) {
                drawLineRight(g, x + xGap, y + yGap, x, y);
                drawTree(g, root.right, x + xGap, y + yGap, xGap / 2);
            }
        }
    }

    private void drawLineLeft(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(yGap * yGap + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 + r * (x2 - x1) / d);
        int x21 = (int) (x2 - r * (x2 - x1) / d);
        int y11 = (int) (y1 - r * yGap / d);
        int y21 = (int) (y2 + r * yGap / d);
        g.drawLine(x11, y11, x21, y21);
    }

    private void drawLineRight(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(yGap * yGap + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 - r * (x1 - x2) / d);
        int x21 = (int) (x2 + r * (x1 - x2) / d);
        int y11 = (int) (y1 - r * yGap / d);
        int y21 = (int) (y2 + r * yGap / d);
        g.drawLine(x11, y11, x21, y21);
    }

    public void insert(int key) {
        this.key = key;
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
}
