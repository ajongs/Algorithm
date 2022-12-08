import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int white = 0;
    static int blue = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        /*
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }*/
        divide(0, 0, n);
        System.out.println(sb);
    }
    public static void divide(int sr, int sc, int length) {
        if (isSame(sr, sc, length)) {
            sb.append(map[sr][sc]);
            return;
        } else {
            int newLength = length / 2;
            sb.append("(");
            divide(sr, sc, newLength);
            divide(sr, sc + newLength, newLength);
            divide(sr + newLength, sc, newLength);
            divide(sr + newLength, sc + newLength, newLength);
            sb.append(")");
        }
    }
    public static boolean isSame(int sr, int sc, int length) {
        int d = length -1;
        int color = map[sr][sc];
        for (int i = sr ; i <= sr + d; i++) {
            for (int j = sc; j <= sc + d; j++) {
                if (color != map[i][j])
                    return false;
            }
        }
        return true;
    }
}
