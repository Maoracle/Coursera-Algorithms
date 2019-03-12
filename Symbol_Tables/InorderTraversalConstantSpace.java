package Symbol_Tables;

public class InorderTraversalConstantSpace<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size; //number of nodes in subtree

        public Node (Key key, Value val, int size) {
            this.key = key;
            this.value = val;
            this.size = size;
        }
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        Node current = root;
        Node previous = null;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.value);
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }
                if (previous.right == null) {
                    previous.right = current;
                    current = current.left;
                }
                else {
                    //if the rightmost child already linked to current (current left children being traversed),
                    //then print current and cut the link to restore tree structure
                    previous.right = null;
                    System.out.println(current.value);
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}

