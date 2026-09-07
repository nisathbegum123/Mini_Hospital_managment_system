public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        // New arrivals join at the rear so removal from the front remains FIFO.
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return patient;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}
