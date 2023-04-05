package binaryTrees;
/*
E)Check if a binary tree is a BST.
*/
public class TreeIsBST {

	public static void main(String[] args) {
	    BinaryTree tree = new BinaryTree();

	    // Create a binary tree
	    tree.root = new Node2(4);
	    tree.root.left = new Node2(2);
	    tree.root.right = new Node2(5);
	    tree.root.left.left = new Node2(1);
	    tree.root.left.right = new Node2(3);

	    // Check if the tree is a binary search tree
	    if (tree.isBST()) {
	        System.out.println("The binary tree is a binary search tree.");
	    } else {
	        System.out.println("The binary tree is not a binary search tree.");
	    }
	}

}//end class

class Node2 {
    int val;
    Node2 left;
    Node2 right;
    Node2(int val) { this.val = val; }
}

class BinaryTree {
    Node2 root;

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node2 root, int minVal, int maxVal) {
        if (root == null) return true;

        if (root.val < minVal || root.val > maxVal) return false;

        return isBST(root.left, minVal, root.val - 1) &&
               isBST(root.right, root.val + 1, maxVal);
    }
}

/*
One approach to check if a binary tree is a BST is to perform an in-order traversal of the tree and check if the elements are in sorted order. If they are, the tree is a BST.
In this implementation, we recursively check if each node satisfies the BST property (i.e., the left subtree is less than the node, and the right subtree is greater than or equal to the node). We pass the minimum and maximum values that the current node can take based on its position in the tree.

This is another Java implementation of a binary tree data structure. The Node2 class represents a single node in the tree, which has an integer value (val) and left and right child nodes (left and right). The BinaryTree class is the main class that holds the root node of the tree and provides methods to manipulate the tree.

The isBST method in the BinaryTree class checks if the binary tree is a binary search tree (BST) or not. This method takes no input parameters and returns a boolean value. It uses a helper method called isBST(Node2 root, int minVal, int maxVal) which takes in the root node of the tree and two integer values minVal and maxVal. The minVal and maxVal parameters represent the minimum and maximum values that the nodes in the subtree rooted at root can take.

The isBST method works recursively as follows:

If the root node is null, return true.
If the value of the root node is less than minVal or greater than maxVal, return false, since this violates the property of a BST.
Recursively check if the left subtree is a BST with minVal as the minimum value and root.val - 1 as the maximum value. Similarly, check if the right subtree is a BST with root.val + 1 as the minimum value and maxVal as the maximum value.
If both the left and right subtrees are BSTs, then the current subtree is also a BST, so return true.
The isBST method is called on the root node of the tree in the BinaryTree class, with Integer.MIN_VALUE and Integer.MAX_VALUE as the initial values of minVal and maxVal. If the method returns true, it means that the binary tree is a BST, otherwise it is not.

Note that this implementation assumes that the values in the tree are unique. If the tree contains duplicate values, this method may not correctly identify the tree as a valid BST.
*/

