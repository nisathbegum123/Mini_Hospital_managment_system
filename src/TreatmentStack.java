public class TreatmentStack {
    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        // The newest completed treatment becomes the top record for LIFO removal.
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is empty.");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}
