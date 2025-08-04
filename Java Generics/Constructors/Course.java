public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "OpenLearn";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 6, 3000);
        Course c2 = new Course("Python", 8, 4000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("TechAcademy");

        c1.displayCourseDetails();  
    }
}