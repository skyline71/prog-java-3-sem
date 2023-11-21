package Practice15;

public class StudentController {
    Student model;
    StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRoll(String roll) {
        model.setRoll(roll);
    }

    public String getStudentRole() {
        return model.getRoll();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRoll());
    }
}
