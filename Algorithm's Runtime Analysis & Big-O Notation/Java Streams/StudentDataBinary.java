import java.io.*;

public class StudentDataBinary {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Example student data
        int[] rollNumbers = {101, 102, 103};
        String[] names = {"Alice", "Bob", "Charlie"};
        double[] gpas = {3.8, 3.5, 3.9};

        // Write student data to file
        writeStudents(rollNumbers, names, gpas);

        // Read and display student data from file
        readStudents();
    }

    private static void writeStudents(int[] rolls, String[] names, double[] gpas) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Write the number of students first
            dos.writeInt(rolls.length);

            for (int i = 0; i < rolls.length; i++) {
                dos.writeInt(rolls[i]);       // roll number (int)
                dos.writeUTF(names[i]);       // name (String)
                dos.writeDouble(gpas[i]);     // GPA (double)
            }
            System.out.println("Student data written to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    private static void readStudents() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int count = dis.readInt();  // read number of students

            System.out.println("Reading " + count + " students from file:");

            for (int i = 0; i < count; i++) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.printf("Roll Number: %d, Name: %s, GPA: %.2f%n", roll, name, gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}
