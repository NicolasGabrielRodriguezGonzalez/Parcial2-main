package Punto4A;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Returns the (possibly new) subtree root so the parent can re-link it
    private TreeNode insertRec(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);            // empty spot: create the node here
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        // equal key: ignored, because codes are unique
        return node;
    }

    public static int contarEquiposEnRango(TreeNode node, int min, int max) {
        // Base case: empty subtree, or a range that cannot contain any key
        if (node == null || min > max) {
            return 0;
        }

        int count = 0;

        // The node itself counts if its key is inside [min, max]
        if (node.key >= min && node.key <= max) {
            count = 1;
        }

        // Left subtree has keys < node.key. It can only contain keys >= min
        // if node.key > min. Otherwise the whole left branch is pruned.
        if (node.key > min) {
            count += contarEquiposEnRango(node.left, min, max);
        }

        // Right subtree has keys > node.key. It can only contain keys <= max
        // if node.key < max. Otherwise the whole right branch is pruned.
        if (node.key < max) {
            count += contarEquiposEnRango(node.right, min, max);
        }

        return count;
    }
    // ===================== 4b) DELETE =====================

    // Deletes a key. With two children the node is replaced by the
    // LARGEST key of its LEFT subtree (in-order predecessor), as the statement asks.
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode node, int key) {
        if (node == null) {
            return null;                          // key not found
        }
        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            if (node.left == null) return node.right;   // leaf or only right child
            if (node.right == null) return node.left;   // only left child

            TreeNode maxLeft = node.left;               // two children:
            while (maxLeft.right != null) {             // go left once, then all the way right
                maxLeft = maxLeft.right;
            }
            node.key = maxLeft.key;                     // copy the predecessor here
            node.left = deleteRec(node.left, maxLeft.key);  // and remove it from the left subtree
        }
        return node;
    }

    // ===================== IN-ORDER =====================

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderRec(root, sb);
        return sb.toString().trim();
    }

    private void inOrderRec(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        inOrderRec(node.left, sb);
        sb.append(node.key).append(" ");
        inOrderRec(node.right, sb);
    }

    // Prints the tree sideways (root on the left, right subtree on top)
    public void printSideways() {
        printRec(root, 0);
    }

    private void printRec(TreeNode node, int level) {
        if (node == null) return;
        printRec(node.right, level + 1);
        System.out.println("      ".repeat(level) + node.key);
        printRec(node.left, level + 1);
    }
}
