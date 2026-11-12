package Punto4A;

public class TreeNode {

    int key;        // equipment code (unique integer)
    TreeNode left;  // subtree with smaller keys
    TreeNode right; // subtree with larger keys

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

}