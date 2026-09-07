public class PatientBST {
    private PatientNode root;

    public boolean insert(Patient patient) {
        if (patient == null) {
            return false;
        }
        if (root == null) {
            root = new PatientNode(patient);
            return true;
        }
        return insert(root, patient);
    }

    private boolean insert(PatientNode current, Patient patient) {
        if (patient.getPatientId() == current.patient.getPatientId()) {
            return false;
        }
        if (patient.getPatientId() < current.patient.getPatientId()) {
            if (current.left == null) {
                current.left = new PatientNode(patient);
                return true;
            }
            return insert(current.left, patient);
        }
        if (current.right == null) {
            current.right = new PatientNode(patient);
            return true;
        }
        return insert(current.right, patient);
    }

    public Patient search(int patientId) {
        PatientNode current = root;
        while (current != null) {
            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }
            current = patientId < current.patient.getPatientId() ? current.left : current.right;
        }
        return null;
    }

    public boolean delete(int patientId) {
        if (search(patientId) == null) {
            return false;
        }
        root = delete(root, patientId);
        return true;
    }

    private PatientNode delete(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }
        if (patientId < current.patient.getPatientId()) {
            current.left = delete(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = delete(current.right, patientId);
        } else {
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // For two children, replace the node with the smallest node in its right subtree.
            PatientNode successor = findMinimum(current.right);
            current.patient = successor.patient;
            current.right = delete(current.right, successor.patient.getPatientId());
        }
        return current;
    }

    private PatientNode findMinimum(PatientNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        displayInOrder(root);
    }

    private void displayInOrder(PatientNode current) {
        if (current == null) {
            return;
        }
        displayInOrder(current.left);
        System.out.println(current.patient);
        displayInOrder(current.right);
    }
}
