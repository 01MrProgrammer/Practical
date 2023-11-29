
public class Employee {

    private static int objectCount = 0;


    private int empId;
    private String name;
    private String deptName;
    private double salary;

  
    public Employee() {
   
        this.objectCount++;
        System.out.println("Object count: " + this.objectCount);
    }

   
    public Employee(int empId, String name, String deptName, double salary) {
        
        this();
        this.empId = empId;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
    }

    
    public static void displayObjectCount() {
        System.out.println("Total number of objects created: " + objectCount);
    }

   
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + deptName);
        System.out.println("Salary: " + salary + "\n");
    }

    public static void main(String[] args) {
      
        Employee emp1 = new Employee(1, "John Doe", "HR", 50000);
        Employee emp2 = new Employee(2, "Jane Smith", "Finance", 60000);
        Employee emp3 = new Employee(3, "Michael Johnson", "IT", 55000);

  
        displayObjectCount();


        System.out.println("Employee 1 details:");
        emp1.displayEmployeeDetails();

        System.out.println("Employee 2 details:");
        emp2.displayEmployeeDetails();

        System.out.println("Employee 3 details:");
        emp3.displayEmployeeDetails();
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }

    public double getSalary() {
        return salary;
    }
}
