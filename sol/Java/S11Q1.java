import java.util.Scanner;


interface Operation {
    double volume(); 
}


class Cylinder implements Operation {
    double radius;
    double height;

   
    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    
    public double volume() {
        return 3.142 * radius * radius * height;
    }
}

public class S11Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius of the cylinder: ");
        double radius = sc.nextDouble();

        System.out.print("Enter the height of the cylinder: ");
        double height = sc.nextDouble();

       
        Cylinder myCylinder = new Cylinder(radius, height);

        double cylinderVolume = myCylinder.volume();

        System.out.println("Cylinder's Volume: " + cylinderVolume);

        sc.close(); 
    }
}
