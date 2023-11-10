package Practice15;

public class EmployeeController {
    Employee model;
    EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public void setEmployeeSalary(double salary) {
        model.setSalary(salary);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public double getEmployeeRole() {
        return model.getSalary();
    }

    public void updateView() {
        view.printEmployeeDetails(model.getName(), model.getSalary());
    }
}