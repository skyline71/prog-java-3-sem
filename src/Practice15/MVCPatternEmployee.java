package Practice15;

public class MVCPatternEmployee {
    public static void main(String[] args) {
        Employee model = retrieveEmployeeFromDatabase();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
        controller.updateView();
        controller.setEmployeeSalary(500);
        controller.updateView();
    }

    public static Employee retrieveEmployeeFromDatabase() {
        Employee employee = new Employee();
        employee.setName("Employee");
        employee.setSalary(1000);
        return employee;
    }
}


