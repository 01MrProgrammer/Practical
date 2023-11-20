import java.util.*;
import java.io.*;

class Clock {
    int H;
    int m;
    int s;
    boolean isAM;

    Clock(int H, int m, int s) {
        this.H = H;
        this.m = m;
        this.s = s;
        this.isAM = true;
    }

    public void setTimeMode(boolean isAM) {
        this.isAM = isAM;
    }

    public void displayTime() {
        String TimeMode = isAM ? "AM" : "PM";
        System.out.println(String.format("%02d:%02d:%02d %s", H, m, s, TimeMode));
    }

    public boolean isValidTime(int H, int m, int s) {
        return (H > 0 && H <= 24) && (m > 0 && m <= 60) && (s > 0 && s <= 60);
    }
}

public class S9Q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hours(1-24): ");
        int H = sc.nextInt();
        System.out.println("Enter Minutes(1-60): ");
        int m = sc.nextInt();
        System.out.println("Enter Seconds(1-60): ");
        int s = sc.nextInt();
        System.out.println("is it AM?(True/False): ");
        boolean isAM = sc.nextBoolean();
        Clock C = new Clock(H, m, s);
        C.setTimeMode(isAM);
        System.out.println("Current Time: ");
        C.displayTime();
        sc.close();
    }
}