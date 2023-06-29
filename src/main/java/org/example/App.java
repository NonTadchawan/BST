package org.example;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        BinaryTreeCanvas treeCanvas = new BinaryTreeCanvas();
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        JTextField textField =new JTextField("set value here.");
        top.add(textField);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e->{
            int key = Integer.parseInt(textField.getText());
            System.out.println(key);
            treeCanvas.insert(key);
            treeCanvas.repaint();
        });
        top.add(addButton);
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(top,BorderLayout.NORTH);
        frame.getContentPane().add(treeCanvas,BorderLayout.CENTER);
        frame.setSize(1500,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
