class TextState {
    String text;
    TextState prev;
    TextState next;

    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    private TextState head;    // Oldest state (for size limiting)
    private TextState tail;    // Latest state
    private TextState current; // Current state in the undo/redo sequence
    private final int maxHistorySize;
    private int size;

    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Add a new state after user action (typing or command)
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        if (head == null) {
            // First state
            head = tail = current = newState;
            size = 1;
        } else {
            // If we have undone some states, remove redo states after current
            if (current != tail) {
                TextState temp = current.next;
                while (temp != null) {
                    TextState next = temp.next;
                    temp.prev = null;
                    temp.next = null;
                    temp = next;
                    size--;
                }
                current.next = null;
                tail = current;
            }

            // Append new state
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            size++;

            // Limit size to maxHistorySize
            if (size > maxHistorySize) {
                // Remove head
                head = head.next;
                head.prev.next = null;
                head.prev = null;
                size--;
            }
        }
    }

    // Undo: revert to previous state if possible
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo: revert to next state if possible
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text State: \"" + current.text + "\"");
        } else {
            System.out.println("No text available.");
        }
    }

    
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.displayCurrentState();

        editor.addState("Hello, World");
        editor.displayCurrentState();

        editor.addState("Hello, World!");
        editor.displayCurrentState();

        System.out.println("\nUndoing:");
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();  // No more undo
        editor.displayCurrentState();

        System.out.println("\nRedoing:");
        editor.redo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.redo(); // No more redo
        editor.displayCurrentState();

        System.out.println("\nAdding new state after undo:");
        editor.undo();
        editor.displayCurrentState();

        editor.addState("Hello again!");
        editor.displayCurrentState();

        System.out.println("\nTrying redo after new state (should not be possible):");
        editor.redo();
        editor.displayCurrentState();
    }
}
