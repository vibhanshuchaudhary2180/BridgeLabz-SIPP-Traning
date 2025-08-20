package Day_2_static_Final.Level_1;

class Hospital {
    static String hospitalName = "Apollo Hospital";
    static int totalPatients = 0;

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }
}

class Patient {
    private String name;
    private int age;
    private String ailment;
    final String patientID;

    Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        Hospital.totalPatients++;
    }

    void displayPatientDetails() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Hospital: " + Hospital.hospitalName);
    }
}

