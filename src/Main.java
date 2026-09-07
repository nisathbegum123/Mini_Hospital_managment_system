import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();
    private static Patient patientInTreatment;
    private static int nextTreatmentId = 1;

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("========================================");
        System.out.println("     MINI HOSPITAL EMERGENCY SYSTEM");
        System.out.println("========================================");
        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientBST.displayInOrder();
                case 5 -> addToEmergencyQueue();
                case 6 -> emergencyQueue.display();
                case 7 -> callNextPatient();
                case 8 -> completeTreatment();
                case 9 -> treatmentStack.display();
                case 10 -> addPatientVisit();
                case 11 -> removePatientVisit();
                case 12 -> searchPatientVisit();
                case 13 -> displayPatientVisits();
                case 14 -> running = false;
                default -> System.out.println("Invalid choice. Please select 1 to 14.");
            }
            System.out.println();
        }
        System.out.println("Thank you for using the Mini Hospital Emergency System.");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. View Emergency Queue");
        System.out.println("7. Call Next Patient for Treatment");
        System.out.println("8. Complete Treatment");
        System.out.println("9. View Treatment History");
        System.out.println("10. Add Patient Visit");
        System.out.println("11. Remove Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Display Patient Visit History");
        System.out.println("14. Exit");
    }

    private static void registerPatient() {
        int id = readPositiveInt("Enter patient ID: ");
        if (patientBST.search(id) != null) {
            System.out.println("A patient with that ID already exists.");
            return;
        }
        String name = readNonEmpty("Enter patient name: ");
        int age = readAge();
        String contact = readNonEmpty("Enter contact number: ");
        String condition = readNonEmpty("Enter medical condition: ");
        patientBST.insert(new Patient(id, name, age, contact, condition));
        System.out.println("Patient registered successfully in the BST.");
    }

    private static void searchPatient() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found.");
        } else {
            System.out.println(patient);
        }
    }

    private static void deletePatient() {
        int id = readPositiveInt("Enter patient ID to delete: ");
        if (patientBST.delete(id)) {
            System.out.println("Patient deleted from the BST.");
        } else {
            System.out.println("Patient was not found.");
        }
    }

    private static void addToEmergencyQueue() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found. Register the patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
        System.out.println("Patient added to the emergency queue (FIFO).");
    }

    private static void callNextPatient() {
        if (patientInTreatment != null) {
            System.out.println("Complete the current treatment before calling another patient.");
            return;
        }
        patientInTreatment = emergencyQueue.dequeue();
        if (patientInTreatment == null) {
            System.out.println("The emergency queue is empty.");
        } else {
            System.out.println("Now treating: " + patientInTreatment);
        }
    }

    private static void completeTreatment() {
        if (patientInTreatment == null) {
            System.out.println("There is no patient currently in treatment.");
            return;
        }
        String doctor = readNonEmpty("Enter doctor name: ");
        String diagnosis = readNonEmpty("Enter treatment/diagnosis: ");
        String date = readNonEmpty("Enter date: ");
        TreatmentRecord record = new TreatmentRecord(nextTreatmentId++, patientInTreatment.getPatientId(),
                patientInTreatment.getPatientName(), doctor, diagnosis, date);
        treatmentStack.push(record);
        System.out.println("Treatment completed and pushed onto the stack.");
        patientInTreatment = null;
    }

    private static void addPatientVisit() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found.");
            return;
        }
        int visitId = readPositiveInt("Enter visit ID: ");
        String date = readNonEmpty("Enter visit date: ");
        String doctor = readNonEmpty("Enter doctor name: ");
        String diagnosis = readNonEmpty("Enter diagnosis: ");
        String treatment = readNonEmpty("Enter treatment: ");
        if (patient.getVisitHistory().addVisit(new Visit(visitId, date, doctor, diagnosis, treatment))) {
            System.out.println("Visit added to the patient's singly linked list.");
        } else {
            System.out.println("That visit ID already exists for this patient.");
        }
    }

    private static void removePatientVisit() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found.");
            return;
        }
        int visitId = readPositiveInt("Enter visit ID to remove: ");
        if (patient.getVisitHistory().removeVisit(visitId)) {
            System.out.println("Visit removed from the linked list.");
        } else {
            System.out.println("Visit was not found or the history is empty.");
        }
    }

    private static void searchPatientVisit() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found.");
            return;
        }
        int visitId = readPositiveInt("Enter visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        System.out.println(visit == null ? "Visit was not found." : visit.toString());
    }

    private static void displayPatientVisits() {
        Patient patient = findPatient();
        if (patient == null) {
            System.out.println("Patient was not found.");
            return;
        }
        System.out.println("Visit history for " + patient.getPatientName() + ":");
        patient.getVisitHistory().display();
    }

    private static Patient findPatient() {
        int id = readPositiveInt("Enter patient ID: ");
        return patientBST.search(id);
    }

    private static int readAge() {
        while (true) {
            int age = readInt("Enter age (1-120): ");
            if (age >= 1 && age <= 120) {
                return age;
            }
            System.out.println("Age must be between 1 and 120.");
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a positive whole number.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty.");
        }
    }
}
