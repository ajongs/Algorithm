import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj_12101 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        List<String>[] dp = new ArrayList[n+2];
        for (int i = 0; i < n+2; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[1].add("1");
        dp[2].add("1+1");
        dp[2].add("2");
        dp[3].add("1+1+1");
        dp[3].add("2+1");
        dp[3].add("1+2");
        dp[3].add("3");
        for (int i = 4; i < n + 1; i++) {
            for (String s : dp[i-1]) {
                dp[i].add(s + "+1");
            }
            for (String s : dp[i-2]) {
                dp[i].add(s + "+2");
            }
            for (String s : dp[i-3]) {
                dp[i].add(s + "+3");
            }
        }
        if (dp[n].size() < k) {
            System.out.println(-1);
        } else {
            Collections.sort(dp[n]);
            System.out.println(dp[n].get(k-1));
        }
    }
}
