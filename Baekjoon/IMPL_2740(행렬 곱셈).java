import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int M;
    private static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(input[j]);
            }
        }
        input = br.readLine().split(" ");
        K = Integer.parseInt(input[1]);
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] answer = mul(A, B);
        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
    public static int[][] mul(int[][] A, int[][] B) {
        int[][] answer = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    answer[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return answer;
    }
}
