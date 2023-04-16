package PPT19;
/*
Given a Binary Search Tree which is also a Complete Binary Tree. The problem is to convert a given BST into a Special Max Heap with the condition that all the values in the left subtree of a node should be less than all the values in the right subtree of the node. This condition is applied to all the nodes in the so-converted Max Heap.

Examples:

Input:          4
               /   \
              2     6
            /  \   /  \
           1   3  5    7

Output:        7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
*/

import java.util.*;

class JavaProgram9
{

    static int i;
    static class Node
    {
        int data;
        Node left, right;
    };

    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers. */
    static Node getNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }


    // Function for the inorder traversal of the tree
// so as to store the node values in 'arr' in
// sorted order
    static void inorderTraversal(Node root, Vector<Integer> arr)
    {
        if (root == null)
            return;

        // first recur on left subtree
        inorderTraversal(root.left, arr);

        // then copy the data of the node
        arr.add(root.data);

        // now recur for right subtree
        inorderTraversal(root.right, arr);
    }

    static void BSTToMaxHeap(Node root, Vector<Integer> arr)
    {
        if (root == null)
            return;

        // recur on left subtree
        BSTToMaxHeap(root.left, arr);

        // recur on right subtree
        BSTToMaxHeap(root.right, arr);

        // copy data at index 'i' of 'arr' to
        // the node
        root.data = arr.get(i++);
    }

    // Utility function to convert the given BST to MAX HEAP
    static void convertToMaxHeapUtil(Node root)
    {
        // vector to store the data of all the nodes of the BST
        Vector<Integer> arr = new Vector<Integer>();
        int i = -1;

        // inorder traversal to populate 'arr'
        inorderTraversal(root, arr);

        // BST to MAX HEAP conversion
        BSTToMaxHeap(root, arr);
    }

    // Function to Print Postorder Traversal of the tree
    static void postorderTraversal(Node root)
    {
        if (root == null)
            return;

        // recur on left subtree
        postorderTraversal(root.left);

        // then recur on right subtree
        postorderTraversal(root.right);

        // print the root's data
        System.out.print(root.data + " ");
    }


    public static void main(String[] args)
    {
        // BST formation
        Node root = getNode(4);
        root.left = getNode(2);
        root.right = getNode(6);
        root.left.left = getNode(1);
        root.left.right = getNode(3);
        root.right.left = getNode(5);
        root.right.right = getNode(7);
        System.out.print("Postorder Traversal of Tree:(before converting to max heap)" +"\n");
        postorderTraversal(root);
        convertToMaxHeapUtil(root);
        System.out.print("\nPostorder Traversal of Tree:(after converting to max heap)" +"\n");
        postorderTraversal(root);

    }
}

