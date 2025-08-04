class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int roll, String name, double cgpa) {
        super(roll, name, cgpa);
    }

    public void showDetails() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Ravi", 8.7);
        pg.showDetails();
        System.out.println("CGPA: " + pg.getCGPA());
    }
}