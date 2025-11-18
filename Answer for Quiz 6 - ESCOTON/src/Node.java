public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            // insert left
            if (leftChild == null) {
                leftChild = new Node(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {
            // insert right
            if (rightChild == null) {
                rightChild = new Node(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public void inOrderTraverse() {
        if (leftChild != null) {
            leftChild.inOrderTraverse();
        }

        System.out.println("Traversed: " + this);

        if (rightChild != null) {
            rightChild.inOrderTraverse();
        }
    }

    public Node get(int value) {
        if (value == data) {
            return this;
        }

        if (leftChild != null && value < data) {
            return leftChild.get(value);
        }

        if (rightChild != null && value > data) {
            return  rightChild.get(value);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}