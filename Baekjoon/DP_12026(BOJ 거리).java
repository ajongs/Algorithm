import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B') {
                arr[i] = 0;
            } else if (str.charAt(i) == 'O') {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) continue;
                if ((arr[j] + 1) % 3 == arr[i]) {
                    if (dp[i] == -1 || dp[i] > dp[j] + (i-j) * (i-j)) {
                        dp[i] = dp[j] + (i-j) * (i-j);
                    }
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}
