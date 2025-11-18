public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(30);
        bst.insert(29);
        bst.insert(26);
        bst.insert(22);
        bst.insert(32);

        bst.inOrderTraverse();

        int value = 100;
        System.out.println("\nNode with value " + value + " - " + bst.get(value));

        //displays the new added code, i was confused why it wasn't popping up
        System.out.println("\nMin node: " + bst.getMin());
        System.out.println("Max node: " + bst.getMax());
        System.out.println("\n=== Descending order ===");
        bst.traverseInOrderDescending();
        //the texts were too close and its bothering me
        // also i think im dyslexic
    }
}