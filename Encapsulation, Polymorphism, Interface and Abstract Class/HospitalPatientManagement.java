import java.util.*;

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String entry);
    void viewRecords();
}

// Abstract Class: Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis; // Sensitive
    private List<String> medicalHistory = new ArrayList<>();

    // Constructor
    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Encapsulation
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void addToHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract Method
    public abstract double calculateBill();

    // Concrete Method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Bill Amount: ₹" + calculateBill());
        System.out.println("-----------------------------------------");
    }
}

// InPatient Class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String entry) {
        addToHistory("InPatient Record: " + entry);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient Class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String entry) {
        addToHistory("OutPatient Record: " + entry);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for OutPatient " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}


public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient in1 = new InPatient("P001", "Rahul Sharma", 45, "Appendicitis", 5, 2500);
        OutPatient out1 = new OutPatient("P002", "Anita Verma", 30, "Fever", 600);

        in1.addRecord("Admitted to Ward 5A.");
        in1.addRecord("Surgery completed successfully.");
        out1.addRecord("Prescribed antibiotics.");

        patients.add(in1);
        patients.add(out1);

        // Polymorphic Billing & Details
        for (Patient p : patients) {
            p.getPatientDetails();
        }

        // View medical history
        System.out.println("\n=== Medical Records ===");
        in1.viewRecords();
        out1.viewRecords();
    }
}