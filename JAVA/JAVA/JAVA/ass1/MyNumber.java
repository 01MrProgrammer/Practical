
public class MyNumber {
    private int num;
    public MyNumber() {
        num = 0;
    }
    public MyNumber(int value) {
        this.num = value;
    }
    public boolean isNegative() {
        return num < 0;
    }
    public boolean isPositive() {
        return num > 0;
    }
    public boolean isZero() {
        return num == 0;
    }
    public boolean isOdd() {
        return num % 2 != 0;
    }
    public boolean isEven() {
        return num % 2 == 0;
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single integer argument.");
            return;
        }

        int value;
        try {
            value = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please provide a valid integer.");
            return;
        }

        MyNumber myNumber = new MyNumber(value);

        System.out.println("Number: " + myNumber.num);
        System.out.println("Is Negative? " + myNumber.isNegative());
        System.out.println("Is Positive? " + myNumber.isPositive());
        System.out.println("Is Zero? " + myNumber.isZero());
        System.out.println("Is Odd? " + myNumber.isOdd());
        System.out.println("Is Even? " + myNumber.isEven());
    }
}

