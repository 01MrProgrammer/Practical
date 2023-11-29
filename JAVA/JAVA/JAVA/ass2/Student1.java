
// Student.java
import SY.SYMarks;
import TY.TYMarks;

class Student {
    public int rollNumber;
    public String name;
    public SYMarks syMarks;
    public TYMarks tyMarks;

    public Student(int rollNumber, String name, SYMarks syMarks, TYMarks tyMarks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.syMarks = syMarks;
        this.tyMarks = tyMarks;
    }

    public int getTotalMarks() {
        int totalSYComputerMarks = syMarks.ComputerTotal;
        int totalTYComputerMarks = tyMarks.Theory + tyMarks.Practicals;

        return totalSYComputerMarks + totalTYComputerMarks;
    }

    public char getGrade() {
        int totalMarks = getTotalMarks();

        if (totalMarks >= 70) {
            return 'A';
        } else if (totalMarks >= 60) {
            return 'B';
        } else if (totalMarks >= 50) {
            return 'C';
        } else if (totalMarks >= 40) {
            return 'P'; // Pass Class
        } else {
            return 'F'; // Fail
        }
    }

    public void displayResult() {
        int totalMarks = getTotalMarks();
        char grade = getGrade();

        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
      
        SYMarks syMarks1 = new SYMarks(80, 85, 90);
        SYMarks syMarks2 = new SYMarks(70, 75, 80);
        TYMarks tyMarks1 = new TYMarks(75, 85);
        TYMarks tyMarks2 = new TYMarks(80, 70);

       
        Student student1 = new Student(101, "John Doe", syMarks1, tyMarks1);
        Student student2 = new Student(102, "Jane Smith", syMarks2, tyMarks2);

        student1.displayResult();
        student2.displayResult();
    }
}


/*

// SY/SYMarks.java
package SY;

public class SYMarks {
    public int ComputerTotal;
    public int MathsTotal;
    public int ElectronicsTotal;

    public SYMarks(int computerTotal, int mathsTotal, int electronicsTotal) {
        ComputerTotal = computerTotal;
        MathsTotal = mathsTotal;
        ElectronicsTotal = electronicsTotal;
    }
}


// TY/TYMarks.java
package TY;

public class TYMarks {
    public int Theory;
    public int Practicals;

    public TYMarks(int theory, int practicals) {
        Theory = theory;
        Practicals = practicals;
    }
}

*/
