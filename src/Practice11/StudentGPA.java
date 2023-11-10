package Practice11;

public class StudentGPA implements Comparator<StudentGPA> {
    private String name;
    private double gpa;

    public StudentGPA(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(StudentGPA object) {
        if(this.gpa > object.gpa) return 1;
        else if(this.gpa < object.gpa) return -1;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Ученик " + name + "\tс итоговым баллом " + gpa;
    }
}