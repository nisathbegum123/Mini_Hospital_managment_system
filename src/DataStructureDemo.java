public class DataStructureDemo {
    public static void main(String[] args) {
        System.out.println("=== BST TEST: insertion, search, deletion, in-order traversal ===");
        PatientBST bst = new PatientBST();
        Patient patient30 = new Patient(30, "Amina Noor", 25, "0700000030", "Asthma");
        Patient patient10 = new Patient(10, "Brian Lee", 41, "0700000010", "Fever");
        Patient patient50 = new Patient(50, "Chloe Smith", 33, "0700000050", "Fracture");
        Patient patient20 = new Patient(20, "David Kim", 19, "0700000020", "Allergy");
        Patient patient40 = new Patient(40, "Eva Jones", 57, "0700000040", "Migraine");
        bst.insert(patient30);
        bst.insert(patient10);
        bst.insert(patient50);
        bst.insert(patient20);
        bst.insert(patient40);
        System.out.println("Patients in ascending ID order:");
        bst.displayInOrder();
        System.out.println("Search ID 40: " + (bst.search(40) != null ? "found" : "not found"));
        System.out.println("Search ID 99: " + (bst.search(99) != null ? "found" : "not found"));
        System.out.println("Delete ID 30: " + (bst.delete(30) ? "deleted" : "not found"));
        bst.displayInOrder();

        System.out.println("\n=== QUEUE TEST: FIFO ===");
        EmergencyQueue queue = new EmergencyQueue();
        queue.enqueue(patient10);
        queue.enqueue(patient20);
        queue.enqueue(patient40);
        queue.display();
        System.out.println("Dequeue 1: " + queue.dequeue().getPatientName());
        System.out.println("Dequeue 2: " + queue.dequeue().getPatientName());
        System.out.println("Dequeue 3: " + queue.dequeue().getPatientName());
        System.out.println("Dequeue empty result: " + queue.dequeue());

        System.out.println("\n=== STACK TEST: LIFO ===");
        TreatmentStack stack = new TreatmentStack();
        stack.push(new TreatmentRecord(1, 10, "Brian Lee", "Dr. Patel", "Fever treated", "2026-09-01"));
        stack.push(new TreatmentRecord(2, 20, "David Kim", "Dr. Musa", "Allergy treated", "2026-09-02"));
        stack.push(new TreatmentRecord(3, 40, "Eva Jones", "Dr. Chen", "Migraine treated", "2026-09-03"));
        stack.display();
        System.out.println("Pop latest record: " + stack.pop());
        System.out.println("Pop after remaining records: " + stack.pop());
        System.out.println("Pop after remaining records: " + stack.pop());
        System.out.println("Pop empty result: " + stack.pop());

        System.out.println("\n=== VISIT LINKED LIST TEST ===");
        patient10.getVisitHistory().addVisit(new Visit(101, "2026-08-01", "Dr. Patel", "Fever", "Medication"));
        patient10.getVisitHistory().addVisit(new Visit(102, "2026-08-20", "Dr. Chen", "Check-up", "Observation"));
        patient10.getVisitHistory().addVisit(new Visit(103, "2026-09-01", "Dr. Patel", "Fever", "Follow-up"));
        patient10.getVisitHistory().display();
        System.out.println("Search visit 102: " + patient10.getVisitHistory().searchVisit(102));
        System.out.println("Remove visit 102: " + patient10.getVisitHistory().removeVisit(102));
        patient10.getVisitHistory().display();
        System.out.println("Search missing visit 999: " + patient10.getVisitHistory().searchVisit(999));
    }
}
