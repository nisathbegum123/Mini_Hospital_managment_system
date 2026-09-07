public class VisitHistory {
    private VisitNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public boolean addVisit(Visit visit) {
        if (visit == null || searchVisit(visit.getVisitId()) != null) {
            return false;
        }
        VisitNode newNode = new VisitNode(visit);
        // Append visits so traversal follows the order in which visits were recorded.
        if (head == null) {
            head = newNode;
            return true;
        }
        VisitNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    public Visit searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            return true;
        }
        VisitNode current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("This patient's visit history is empty.");
            return;
        }
        VisitNode current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}
