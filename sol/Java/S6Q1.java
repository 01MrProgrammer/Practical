import java.util.Scanner;

class Employee {
    int eid;
    String ename;
    String desg;
    float esal;

    Employee(int eid, String ename, String desg, float esal) {
        this.eid = eid;
        this.ename = ename;
        this.desg = desg;
        this.esal = esal;
    }

    @Override
    public String toString() {
        return "Employee ID: " + eid + "\n" + "Employee NAME" + ename + "\n" + "Employee DESIGNATION" + desg + "\n"
                + "Employee SALARY" + esal + "\n";
    }
}

public class S6Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter How many Employees: ");
        int n = sc.nextInt();
        Employee[] e = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Employee ID: ");
            int eid = sc.nextInt();
            System.out.println("Enter the Employee NAME: ");
            sc.nextLine();
            String ename = sc.nextLine();
            System.out.println("Enter the Employee DESIGNATION: ");
            String desg = sc.nextLine();
            System.out.println("Enter the Employee SALARY: ");
            float esal = sc.nextFloat();
            e[i] = new Employee(eid, ename, desg, esal);
        }
        sc.close();
    }
}
