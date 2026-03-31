class TextState {

    private String content;

    public TextState(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }
    
}

class TextNode {

    private TextState state;
    private TextNode previous;
    private TextNode next;

    public TextNode(TextState state) {
        this.state = state;
    }

    public TextNode getPrevious() {
        return previous;
    }

    public void setPrevious(TextNode previous) {
        this.previous = previous;
    }

    public TextNode getNext() {
        return next;
    }

    public void setNext(TextNode next) {
        this.next = next;
    }

    public TextState getState() {
        return state;
    }
}

public class UndoRedoFunctionalityForTextEditor {
    
    private TextNode textHead;
    private TextNode textTail;
    private TextNode current;
    private int size;
    private final int maxHistory;

    public UndoRedoFunctionalityForTextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.size = 0;
    }

    //Method to ad a new state
    public void addTextState(String content) {

        TextState textState = new TextState(content);
        TextNode newNode = new TextNode(textState);

        if (textHead == null) {
            textHead = textTail = current = newNode;
            size = 1;
            return;
        }

        if (current.getNext() != null) {

            TextNode temp = current.getNext();

            while (temp != null) {
                TextNode next = temp.getNext();
                temp.setPrevious(null);
                temp.setNext(null);
                temp = next;
                size--;
            }

            current.setNext(null);
            textTail = current;

        }

        current.setNext(newNode);
        newNode.setPrevious(current);
        current = newNode;
        textTail = newNode;
        size++;

        if (size > maxHistory) {
            textHead = textHead.getNext();
            textHead.setPrevious(null);
            size--;
        }

    }

    //Method of undo functionality
    public void undo() {
        if (current != null && current.getPrevious() != null) {
            current = current.getPrevious();
            System.out.println("Undo performed successfully. Current state: " + current.getState().getContent());
        } 
        else {
            System.out.println("No text state to undo.");
        }
    }

    //Method of redo functionality
    public void redo() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
            System.out.println("Redo performed successfully");
        } 
        else {
            System.out.println("No text state to redo.");
        }
    }

    //Method to display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current text state: " + current.getState().getContent());
        } 
        else {
            System.out.println("No text state available.");
        }
    }

    //Method to display the full history
    public void displayEditorHistory(){
        System.out.println("History:");
        TextNode temp = textHead;
        while (temp != null) {
            String marker = (temp == current) ? "<-- current state" : "";
            System.out.println(temp.getState().getContent() + " " + marker);
            temp = temp.getNext();
        }
    }

    //Main method for testing
    public static void main(String[] args) {
        UndoRedoFunctionalityForTextEditor textEditor = new UndoRedoFunctionalityForTextEditor(10);

        textEditor.addTextState("Good");
        textEditor.addTextState("Good Morning");
        textEditor.addTextState("Good Morning, Apurva!");
        textEditor.displayCurrentState();

        textEditor.undo();
        textEditor.undo();

        textEditor.displayCurrentState();

        textEditor.redo();
        textEditor.redo();

        textEditor.displayCurrentState();

        textEditor.addTextState("Good Afternoon");
        textEditor.addTextState("Good Afternoon, Ava!");

        textEditor.displayEditorHistory();
    }
}
