package greedyAlgorithms;

import java.util.PriorityQueue;

/*
A)Huffman Coding: Given a set of characters and their frequencies, construct a binary tree using Huffman coding to minimize the total encoding length. 
*/
class HuffmanCoding {
    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node other) {
            return freq - other.freq;
        }
    }

    public Node buildTree(char[] chars, int[] freqs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < chars.length; i++) {
            pq.offer(new Node(chars[i], freqs[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.offer(parent);
        }

        return pq.poll();
    }

    public void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.isLeaf()) {
            System.out.println(root.ch + ": " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqs = {5, 9, 12, 13, 16, 45};

        HuffmanCoding hc = new HuffmanCoding();
        Node root = hc.buildTree(chars, freqs);
        hc.printCodes(root, "");
    }
}

/*
The code builds a binary tree using the given characters and their frequencies, and prints the Huffman codes for each character. The buildTree method uses a priority queue to merge the two nodes with the lowest frequencies at each step, until a single root node is left. The printCodes method recursively traverses the tree, assigning '0' to left edges and '1' to right edges, and printing the codes for each leaf node.
*/

