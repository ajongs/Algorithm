import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);
        str = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(str[i-1]);
        }

        int[][] dp = new int[n+1][m+1];
        /*
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }*/
        dp[0][s] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(dp[i-1][j] == 0) {
                    continue;
                } else {
                  int plus = j + arr[i];
                  int minus = j - arr[i];

                  if (rangeCheck(plus, m)) {
                     dp[i][plus] = 1;
                  }
                  if (rangeCheck(minus, m)) {
                      dp[i][minus] = 1;
                  }
                }
            }
        }
        System.out.println(getAnswer(dp, n, m));
    }
    public static boolean rangeCheck(int num, int m) {
        if (num < 0 || num > m) {
            return false;
        }
        return true;
    }
    public static int getAnswer(int[][] dp, int n, int m) {
        for(int i = m; i>=0; i--) {
            if (dp[n][i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
