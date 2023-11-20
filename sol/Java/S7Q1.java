import java.util.Scanner;

class Bank {
    float bal;

    Bank(float bal) {
        this.bal = bal;
    }

    public void deposite(float amt) {
        if (amt > 0) {
            bal = bal + amt;
            System.out.println("Deposited: $" + amt);
        } else {
            System.out.println("Invalid Deposite Amount");
        }
    }

    public void withdraw(float amt) {
        if (amt <= bal && amt > 0) {
            bal = bal - amt;
            System.out.println("Withdrawn: " + amt);
        } else if (amt <= 0) {
            System.out.println("Invalid Withdrawl Amount");
        } else {
            System.out.println("Aukat ke bahar");
        }
    }

    public double getbalance() {
        System.out.println("Current Balance: $" + bal);
        return bal;
    }
}

public class S7Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Initial Balance: ");
        float IB = sc.nextFloat();
        Bank B = new Bank(IB);
        B.getbalance();
        System.out.println("Enter Deposite Amount: $");
        float damt = sc.nextFloat();
        B.deposite(damt);
        System.out.println("Enter the Withdrawl Amount: $");
        float wamt = sc.nextFloat();
        B.withdraw(wamt);
        B.getbalance();
        sc.close();
    }
}
