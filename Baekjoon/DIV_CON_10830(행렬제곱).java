import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int P = 1_000;
    private static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        long b = Long.parseLong(input[1]);
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]) % P;
            }
        }
        int[][] result = pow(arr, b);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
    public static int[][] pow(int[][] base, long expo) {
        if (expo == 1) {
            return base;
        }

        int[][] temp = pow(base, expo / 2);

        if (expo % 2 == 1) {
            return mul(mul(temp, temp), base);
        }
        return mul(temp, temp);
    }
    public static int[][] mul(int[][] A, int[][] B) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[i][j] += A[i][k] * B[k][j];
                    temp[i][j] %= P;
                }
            }
        }
        return temp;
    }
}
