import java.util.*;

// Abstract JobRole class
abstract class JobRole {
    private String name;
    private int experienceYears;

    public JobRole(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract String getRequiredSkill();
}

// Concrete Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int experienceYears) {
        super(name, experienceYears);
    }

    @Override
    public String getRequiredSkill() {
        return "Java";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, int experienceYears) {
        super(name, experienceYears);
    }

    @Override
    public String getRequiredSkill() {
        return "Python & Machine Learning";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, int experienceYears) {
        super(name, experienceYears);
    }

    @Override
    public String getRequiredSkill() {
        return "Product Strategy";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public T getCandidate() {
        return candidate;
    }

    public void displayResume() {
        System.out.println("Candidate Name: " + candidate.getName());
        System.out.println("Experience: " + candidate.getExperienceYears() + " years");
        System.out.println("Applying for: " + candidate.getClass().getSimpleName());
        System.out.println("Key Skill: " + candidate.getRequiredSkill());
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    
    // Generic method using wildcard
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Screening resume for: " + role.getClass().getSimpleName());
            System.out.println("Name: " + role.getName());
            System.out.println("Experience: " + role.getExperienceYears() + " years");
            System.out.println("Required Skill: " + role.getRequiredSkill());
            System.out.println(role.getExperienceYears() >= 2 ? "Status: Shortlisted" : "Status: Rejected");
            System.out.println("--------------------------------------");
        }
    }
}

// Main class to test
public class ResumeScreeningApp {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 3));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 1));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 5));

        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(seResume.getCandidate());
        resumeList.add(dsResume.getCandidate());
        resumeList.add(pmResume.getCandidate());

        // Display individual resumes
        seResume.displayResume();
        System.out.println();
        dsResume.displayResume();
        System.out.println();
        pmResume.displayResume();
        System.out.println("\n--- Screening Resumes ---\n");

        // Process all resumes using wildcard method
        ResumeScreeningSystem.processResumes(resumeList);
    }
}
