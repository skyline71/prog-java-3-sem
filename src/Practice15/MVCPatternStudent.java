package Practice15;

public class MVCPatternStudent {
    public static void main(String[] args) {
        Student model =  retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("New student");
        controller.updateView();
    }

    public static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Student");
        student.setRoll("Roll");
        return student;
    }
}
