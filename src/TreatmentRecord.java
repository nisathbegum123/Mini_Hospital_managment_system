public class TreatmentRecord {
    private final int treatmentId;
    private final int patientId;
    private final String patientName;
    private final String doctorName;
    private final String treatmentDiagnosis;
    private final String date;

    public TreatmentRecord(int treatmentId, int patientId, String patientName, String doctorName,
                           String treatmentDiagnosis, String date) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatmentDiagnosis = treatmentDiagnosis;
        this.date = date;
    }

    public int getTreatmentId() { return treatmentId; }
    public int getPatientId() { return patientId; }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId + " | Patient ID: " + patientId
                + " | Patient: " + patientName + " | Doctor: " + doctorName
                + " | Treatment/Diagnosis: " + treatmentDiagnosis + " | Date: " + date;
    }
}
