package binaryTrees;
/*
C)Find the lowest common ancestor of two nodes in a BST
*/
public class lowestCommonAncestorBST {

	public static void main(String[] args) {
	    // create a binary search tree with some values
	    BST bst = new BST();
	    bst.root = new Node(6);
	    bst.root.left = new Node(2);
	    bst.root.right = new Node(8);
	    bst.root.left.left = new Node(0);
	    bst.root.left.right = new Node(4);
	    bst.root.right.left = new Node(7);
	    bst.root.right.right = new Node(9);

	    // find the lowest common ancestor of two nodes
	    Node p = bst.root.left.left;
	    Node q = bst.root.left.right;
	    Node lca = bst.lowestCommonAncestor(bst.root, p, q);

	    // print the value of the lowest common ancestor
	    System.out.println("Lowest common ancestor of " + p.val + " and " + q.val + " is " + lca.val);
	}


}

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) { this.val = val; }
}

class BST {
    Node root;

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}

/*
The lowest common ancestor (LCA) of two nodes in a BST is the node that is the closest ancestor to both nodes. One approach to find the LCA of two nodes p and q in a BST is to traverse the tree from the root and keep track of the last node that is less than p and greater than q.
In this implementation, we check if root is greater than both p and q. If it is, we recurse on the left subtree. If it is less than both p and q, we recurse on the right subtree. Otherwise, we return root, which is the LCA.

This is a Java implementation of a Binary Search Tree (BST) data structure. The Node class represents a single node in the tree, which has an integer value (val) and left and right child nodes (left and right). The BST class is the main class that holds the root node of the tree and provides methods to manipulate the tree.

The lowestCommonAncestor method in the BST class takes in the root node of the tree, and two nodes p and q whose lowest common ancestor needs to be found. This method recursively traverses the tree and returns the lowest common ancestor of p and q. The logic used in the method is as follows:

If the root node is null, return null.
If both p and q are smaller than the current root node's value, the lowest common ancestor must be in the left subtree, so we recursively call the lowestCommonAncestor method on the left child of the current node.
If both p and q are greater than the current root node's value, the lowest common ancestor must be in the right subtree, so we recursively call the lowestCommonAncestor method on the right child of the current node.
If none of the above conditions are satisfied, the current node must be the lowest common ancestor, so we return it.
This method assumes that both p and q are present in the tree and that the tree is a valid BST. If either of these conditions is not met, the method may not return the correct result.
*/
