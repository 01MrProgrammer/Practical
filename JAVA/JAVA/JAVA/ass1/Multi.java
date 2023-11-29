


public class Multi { //MultiplicationTables
    public static void main(String[] args) {
        int n = 15; // The number of tables to display

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= n; j++) {
                int result = i * j;
                System.out.printf("%2d * %2d = %3d\n", j, i, result);
            }
            System.out.println();
        }
    }
}
