import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){              // Constructor
        this.name = name;
        this.id = id;
    }
public String getName(){
        return name;
}
public int getId(){
        return id;
}
  abstract public double calculateSalary();

 @Override
    public String toString(){
     return "Employees [name ="+name+",id="+id+",salary="+calculateSalary()+"]";
 }
}
class FullTimeEmployee extends Employee{

    private double monthlysalary;
    public FullTimeEmployee(String name,int id,double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }
    @Override
    public double calculateSalary(){
       return monthlysalary;
    }

}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private  double hourlyRate;
    public PartTimeEmployee(String name, int id,int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public  PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }
        public void displayEmployees(){
            for (Employee employee : employeeList){
                System.out.println(employee);

        }
    }
}

public class Main {
    public static void main(String[] arggs){
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas",1,70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Rohit",2,40,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details : ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();


    }
}
