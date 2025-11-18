public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        }
    }

    public Node get(int value) {
        if (root == null) {
            return  null;
        }

        return  root.get(value);
    }

    //returns node with the least value
    public Node getMin() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    //returns node with the max value
    public Node getMax() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    //traverses the tree with in-order method
    public void traverseInOrderDescending() {
        if (root != null) {
            traverseInOrderDescending(root);
        }
    }
    private void traverseInOrderDescending(Node node) {
        if (node.getRightChild() != null) {
            traverseInOrderDescending(node.getRightChild());
        }
        System.out.println("Traversed: " + node);
        if (node.getLeftChild() != null) {
            traverseInOrderDescending(node.getLeftChild());
        }
    }
}