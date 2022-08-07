import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        String[] result = new String[n+1];

        dp[1] = 0;
        result[1] = "1";
        for(int i=2; i<n+1; i++){
            int nextIdx=0;
            int min=Integer.MAX_VALUE;
            if(i%3==0){
                if(min > dp[i/3]){
                    nextIdx = i/3;
                    min = dp[i/3];
                }
            }
            if(i%2==0){
                if(min > dp[i/2]){
                    nextIdx = i/2;
                    min = dp[i/2];
                }
            }
            if(min > dp[i-1]){
                    nextIdx = i-1;
                    min = dp[i-1];
                }
            dp[i] = 1 + dp[nextIdx];
            result[i] = i + " " + result[nextIdx];
        }
        System.out.println(dp[n]);
        System.out.println(result[n]);

    }
}
