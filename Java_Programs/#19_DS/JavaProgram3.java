package PPT19;

/*
Given a binary tree, the task is to find the height of the tree.
Height of the tree is the number of edges in the tree from the root to
the deepest node, Height of the empty tree is 0.
*/

// A binary tree node
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class JavaProgram3 {
    Node root;

    /* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }


    public static void main(String[] args)
    {
        JavaProgram3 tree = new JavaProgram3();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is "
                + tree.maxDepth(tree.root));
    }
}


