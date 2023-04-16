package PPT19;

/*
Given a binary tree, check if it has heap property or not, Binary tree needs to fulfill the following two conditions for being a heap –

It should be a complete tree (i.e. all levels except the last should be full).
Every node’s value should be greater than or equal to its child node (considering max-heap).

*/


// A Binary Tree node
class NodeOfTree {
    int key;
    NodeOfTree left, right;

    NodeOfTree(int k)
    {
        key = k;
        left = right = null;
    }
}

public class JavaProgram5 {
    /* This function counts the number of nodes in a binary tree */
    int countNodes(NodeOfTree root)
    {
        if (root == null)
            return 0;
        return (1 + countNodes(root.left)
                + countNodes(root.right));
    }

    /* This function checks
    if the binary tree is complete
    * or not */
    boolean isCompleteUtil(NodeOfTree root, int index,
                           int number_nodes)
    {
        // An empty tree is complete
        if (root == null)
            return true;

        // If index assigned to current
        // node is more than number of
        // nodes in tree, then tree is
        // not complete
        if (index >= number_nodes)
            return false;

        // Recur for left and right subtrees
        return isCompleteUtil(root.left, 2 * index + 1,
                number_nodes)
                && isCompleteUtil(root.right, 2 * index + 2,
                number_nodes);
    }

    // This Function checks
    // the heap property in the tree.
    boolean isHeapUtil(NodeOfTree root)
    {
        // Base case : single
        // node satisfies property
        if (root.left == null && root.right == null)
            return true;

        // node will be in second last level
        if (root.right == null) {
            // check heap property at Node
            // No recursive call ,
            // because no need to check last level
            return root.key >= root.left.key;
        }
        else {
            // Check heap property at Node and
            // Recursive check heap property at left and
            // right subtree
            if (root.key >= root.left.key
                    && root.key >= root.right.key)
                return isHeapUtil(root.left)
                        && isHeapUtil(root.right);
            else
                return false;
        }
    }

    // Function to check binary tree is a Heap or Not.
    boolean isHeap(NodeOfTree root)
    {
        if (root == null)
            return true;

        // These two are used in isCompleteUtil()
        int node_count = countNodes(root);

        if (isCompleteUtil(root, 0, node_count) == true
                && isHeapUtil(root) == true)
            return true;
        return false;
    }


    public static void main(String args[])
    {
        JavaProgram5 bt
                = new JavaProgram5();
        //insert nodes
        NodeOfTree root = new NodeOfTree(10);
        root.left = new NodeOfTree(9);
        root.right = new NodeOfTree(8);
        root.left.left = new NodeOfTree(7);
        root.left.right = new NodeOfTree(6);
        root.right.left = new NodeOfTree(5);
        root.right.right = new NodeOfTree(4);
        root.left.left.left = new NodeOfTree(3);
        root.left.left.right = new NodeOfTree(2);
        root.left.right.left = new NodeOfTree(1);

        if (bt.isHeap(root) == true)
            System.out.println(
                    "Given binary tree is a Heap");
        else
            System.out.println(
                    "Given binary tree is not a Heap");
    }
}


