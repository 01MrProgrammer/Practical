public class Q1 {
    public static void main(String[] args) {
        if(args.length < 4) {
            System.out.println("Please provide first name, last name, weight (in kg), and height (in meters) as command line arguments.");
            return;
        }

        String firstName = args[0];
        String lastName = args[1];
        double weight = Double.parseDouble(args[2]);
        double height = Double.parseDouble(args[3]);

        double bmi = weight / (height * height);

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + bmi);
    }
}

