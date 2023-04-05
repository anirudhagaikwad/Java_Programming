package binaryTrees;
/*
Binary search tree (BST) is a popular data structure in computer science. It is a binary tree where each node has at most two children (left and right), and the left child is less than the parent node, while the right child is greater than or equal to the parent node.
In this implementation, we have a Node class to represent each node in the BST. The BST class has a root field which points to the root of the tree. We have implemented insert operation to insert a new element in the BST, delete operation to remove an element from the BST, and search operation to search for an element in the BST.
*/
class Node3 {
    int val;
    Node3 left;
    Node3 right;

    Node3(int val) {
        this.val = val;
    }
}

class BinarySearchTree {
    Node3 root;

    BinarySearchTree() {
        this.root = null;
    }

    // Insertion operation
    void insert(int val) {
        this.root = insertHelper(this.root, val);
    }

    Node3 insertHelper(Node3 root, int val) {
        if (root == null) {
            return new Node3(val);
        }

        if (val < root.val) {
            root.left = insertHelper(root.left, val);
        } else {
            root.right = insertHelper(root.right, val);
        }

        return root;
    }

    // Deletion operation
    void delete(int val) {
        this.root = deleteHelper(this.root, val);
    }

    Node3 deleteHelper(Node3 root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteHelper(root.left, val);
        } else if (val > root.val) {
            root.right = deleteHelper(root.right, val);
        } else {
            // case 1: no children
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case 2: one child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // case 3: two children
            else {
                Node3 successor = findSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteHelper(root.right, successor.val);
            }
        }

        return root;
    }

    Node3 findSuccessor(Node3 root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Searching operation
    boolean search(int val) {
        return searchHelper(this.root, val);
    }

    boolean searchHelper(Node3 root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        } else if (val < root.val) {
            return searchHelper(root.left, val);
        } else {
            return searchHelper(root.right, val);
        }
    }

    // Updating operation
    void update(int oldVal, int newVal) {
        delete(oldVal);
        insert(newVal);
    }

    // Printing operation (in-order traversal)
    void print() {
        printHelper(this.root);
        System.out.println();
    }

    void printHelper(Node3 root) {
        if (root != null) {
            printHelper(root.left);
            System.out.print(root.val + " ");
            printHelper(root.right);
        }
    }

    public static void main(String[] args) {
        // Create a new BST
        BinarySearchTree bst = new BinarySearchTree();

        // Insert some nodes
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        // Print the BST using in-order traversal
        System.out.print("In-order traversal: ");
        bst.print();

        // Search for a node
        int searchVal = 6;
        if (bst.search(searchVal)) {
            System.out.println(searchVal + " found in BST");
        } else {
            System.out.println(searchVal + " not found in BST");
        }

        // Update a node value
        int updateVal = 13;
        int newUpdateVal = 15;
        bst.update(updateVal, newUpdateVal);
        System.out.println("Updated " + updateVal + " to " + newUpdateVal);
        System.out.print("In-order traversal after update: ");
        bst.print();

        // Delete a node
        int deleteVal = 6;
        bst.delete(deleteVal);
        System.out.println("Deleted " + deleteVal);
        System.out.print("In-order traversal after delete: ");
        bst.print();
    }

}

/*
The implementation consists of two classes: Node3 and BinarySearchTree. The Node3 class represents a node in the binary search tree and has an integer value, a left child node, and a right child node. The BinarySearchTree class represents the binary search tree itself and has a root node.

The BinarySearchTree class has several methods for manipulating the binary search tree:

insert: inserts a new node with the given value into the binary search tree
delete: deletes a node with the given value from the binary search tree
search: searches for a node with the given value in the binary search tree
update: updates a node with the given old value to the given new value in the binary search tree
print: prints the binary search tree in in-order traversal
The insert method uses the insertHelper method, which is a recursive method that traverses the binary search tree to find the correct position for the new node. The delete method uses the deleteHelper method, which is also a recursive method that traverses the binary search tree to find the node to delete. If the node has no children, it is simply deleted. If the node has one child, that child is promoted to take the place of the deleted node. If the node has two children, the algorithm finds the successor of the node (the smallest node in the right subtree), replaces the value of the node with the value of the successor, and then recursively deletes the successor node.

The search method uses the searchHelper method, which is a recursive method that traverses the binary search tree to find the node with the given value. The update method simply deletes the node with the old value and inserts a new node with the new value.

The print method uses the printHelper method, which is a recursive method that prints the binary search tree in in-order traversal (i.e., left subtree, node, right subtree).

Finally, the main method creates a new binary search tree, inserts some nodes, searches for a node, updates a node, and deletes a node, demonstrating the use of the various methods.

*/
