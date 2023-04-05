package binaryTrees;
import java.util.Stack;
/*
D)Find the kth smallest element in a BST
*/
public class KthSmallestElementBST {

	public static void main(String[] args) {
	    // create a binary search tree with some values
	    BST1 bst = new BST1();
	    bst.root = new Node1(5);
	    bst.root.left = new Node1(3);
	    bst.root.right = new Node1(7);
	    bst.root.left.left = new Node1(2);
	    bst.root.left.right = new Node1(4);
	    bst.root.right.left = new Node1(6);
	    bst.root.right.right = new Node1(8);

	    // find the kth smallest element in the tree
	    int k = 3;
	    int kthSmallest = bst.kthSmallest(bst.root, k);

	    // print the kth smallest element
	    System.out.println("The " + k + "th smallest element in the tree is " + kthSmallest);
	}


}

class Node1 {
    int val;
    Node1 left;
    Node1 right;
    Node1(int val) { this.val = val; }
}

class BST1 {
    Node1 root;

    public int kthSmallest(Node1 root, int k) {
        Stack<Node1> stack = new Stack<>();
        Node1 curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }

        return -1;
    }
}

/*
One approach to find the kth smallest element in a BST is to do an in-order traversal of the tree and keep track of the count of nodes visited. When we have visited k nodes, we return the value of the current node.
In this implementation, we use a stack to perform an in-order traversal of the tree. When we pop a node off the stack, we decrement k. When k becomes 0, we return the value of the current node.

This is another Java implementation of a Binary Search Tree (BST) data structure. The Node1 class represents a single node in the tree, which has an integer value (val) and left and right child nodes (left and right). The BST1 class is the main class that holds the root node of the tree and provides methods to manipulate the tree.

The kthSmallest method in the BST1 class takes in the root node of the tree and an integer k, and returns the kth smallest element in the tree. This method uses a stack to traverse the tree in-order iteratively, keeping track of the current node and its left and right child nodes. The logic used in the method is as follows:

Initialize an empty stack and set the current node to the root node of the tree.
While the current node is not null or the stack is not empty, keep traversing the left subtree of the current node by pushing all its left child nodes onto the stack.
Once the left subtree of the current node has been completely traversed, pop the top node from the stack and check if it is the kth smallest element. If it is, return its value.
If the kth smallest element has not been found yet, set the current node to the right child of the popped node and repeat the process from step 2.
If the kth smallest element is not found in the tree, the method returns -1.

This method assumes that the input value of k is valid and is within the range of the number of elements in the tree. If k is greater than the number of elements in the tree, the method may not return the correct result.
*/

