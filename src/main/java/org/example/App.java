package org.example;

public class App 
{
    public static void main( String[] args )
    {
        BinaryTree tree=new BinaryTree();
        tree.insert(3);
        tree.insert(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(7);
        tree.insert(5);
        tree.insert(14);
        tree.insert(4);


        tree.delete(3);
        tree.delete(6);
        tree.delete(7);

        tree.search();
    }
}
