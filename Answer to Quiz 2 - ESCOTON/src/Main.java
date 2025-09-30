public class Main {

    private class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public Main() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adding element at the end of the list
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Removing the first element
    public String removeFirst() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    // Checker
    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (data == null ? current.data == null : data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Finding the index of an element
    public int indexOf(String data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (data == null ? current.data == null : data.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Print the list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        Main list = new Main();

        // Elements
        list.add("Heathcliff");
        list.add("Asuna");
        list.add("LethalBacon");
        list.add("HPDeskjet");

        System.out.println("Initial list:");
        list.printList();
        System.out.println("Size: " + list.size());

        // Test contains
        System.out.println("Contains Asuna: " + list.contains("Asuna"));
        System.out.println("Contains XYZ: " + list.contains("XYZ"));

        // Test indexOf
        System.out.println("Index of LethalBacon: " + list.indexOf("LethalBacon"));
        System.out.println("Index of XYZ: " + list.indexOf("XYZ"));

        // Test removing first element
        System.out.println("Removed first element: " + list.removeFirst());
        System.out.println("List after removing first element:");
        list.printList();
        System.out.println("Size: " + list.size());
    }
}