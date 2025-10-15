import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;

    public CardStack(int capacity) {
        stack = new Card[capacity];
        top = 0;
    }

    public void push(Card card) {
        if (top == stack.length) {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = card;
    }

    public Card pop() {
        if (isEmpty()) {
            return null;
        }

        return stack[--top];
    }

    public Card peek() {
        if (isEmpty()) {
            return null;
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i].getName());
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}