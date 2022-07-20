import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<=i; j++){
                dp[i][j] = Integer.parseInt(str[j]);
            }
        }
       //아래서 부터 위로 올라가면 마지막에 dp[4][0] ~ [4][4] 까지 for문 돌려 비교할 필요가 없음
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
