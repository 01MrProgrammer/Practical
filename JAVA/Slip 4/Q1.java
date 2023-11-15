public class Q1 {
    public static void main(String[] args) {
        int[][] original = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Array:");
        printArray(original);

        int[][] transposed = transposeArray(original);

        System.out.println("Transposed Array:");
        printArray(transposed);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transposeArray(int[][] original) {
        int[][] transposed = new int[original[0].length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                transposed[j][i] = original[i][j];
            }
        }
        return transposed;
    }
}
