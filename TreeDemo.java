
/**
 * A class representing a node in a tree
 */
class Node {

    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

}

/**
 * A class for representing a binary search tree, with inserting, deletion, and
 * printing
 */
class BinarySearchTree {

    Node root;

    /**
     * Inserts a new value into the binary search tree, as a leaf node
     *
     * @param value the value to insert into the tree
     */
    public void insert(int value) {
        //tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else 
    }

    /**
     * Prints the value of every node in preorder order
     *
     * @param root the root of the tree
     */
    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // print value of this node
        System.out.print(root.value + " ");

        // traverse left subtree
        preOrderTraversal(root.left);

        // traverse right subtree
        preOrderTraversal(root.right);

    }

    /**
     * Prints the value of every node in inorder order
     *
     * @param root the root of the tree
     */
    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // traverse left subtree
        inOrderTraversal(root.left);

        // print value of this node
        System.out.print(root.value + " ");

        // traverse right subtree
        inOrderTraversal(root.right);
    }

    /**
     * Prints the value of every node in postorder order
     *
     * @param root the root of the tree
     */
    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // traverse left subtree
        postOrderTraversal(root.left);

        // traverse right subtree
        postOrderTraversal(root.right);

        // print value of this node
        System.out.print(root.value + " ");

    }

    /**
     * A method that checks if a node with the given value exists in the tree
     *
     * @param root the root of the tree
     * @param key the value to look for
     * @return true if the key exists in the tree, and fals if it doesn't
     */
    // "find" is a bad name for a function that returns a boolean, in my opinion, but it's what I'm stuck with
    public boolean find(Node root, int key) {
        // I could do it iteratively, but doing it recursively because I'm very lazy
        if (root == null) {
            return false;
        } else if (root.value == key) {
            return true;
        } else {
            return find(root.left, key) || find(root.right, key);
        }
    }

    /**
     * A method that finds the minimum value in the binary search tree
     *
     * @param root the root node of the tree
     * @return the minimum value of a node in the binary search tree
     * @throws IllegalArgumentException if the root is null
     */
    public int getMin(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null.");
        } else if (root.left == null && root.right == null) {
            return root.value;
        } else if (root.left == null) {
            return Math.min(root.value, getMin(root.right));
        } else if (root.right == null) {
            return Math.min(root.value, getMin(root.left));
        } else {
            return Math.min(root.value, Math.min(getMin(root.left), getMin(root.right)));
        }
    }

    /**
     * A method that finds the maximum value in the binary search tree
     *
     * @param root the root node of the tree
     * @return the maximum value of a node in the binary search tree
     * @throws IllegalArgumentException if the root is null
     */
    public int getMax(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null.");
        } else if (root.left == null && root.right == null) {
            return root.value;
        } else if (root.left == null) {
            return Math.max(root.value, getMax(root.right));
        } else if (root.right == null) {
            return Math.max(root.value, getMax(root.left));
        } else {
            return Math.max(root.value, Math.max(getMax(root.left), getMax(root.right)));
        }

    }

    /**
     * A method that deletes the node with the given value from the tree
     *
     * @param root the root of the tree
     * @param key the value to delete
     * @return the new tree
     */
    public Node delete(Node root, int key) {

        if (root == null) {
            return root;
        } else if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            //node has been found
            if (root.left == null && root.right == null) {
                //case #1: leaf node
                root = null;
            } else if (root.right == null) {
                //case #2 : only left child
                root = root.left;
            } else if (root.left == null) {
                //case #2 : only right child
                root = root.right;
            } else {
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }

}

/**
 * The class that has the main method because Java needs that type of crap
 */
public class TreeDemo {

    /**
     * The method for starting the program, since yes you're looking at Java
     * (TM) code. How wonderful
     *
     * @param args don't worry about these
     */
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();

    }
}
