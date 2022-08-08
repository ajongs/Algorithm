import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] dp = new int[k+1];
        int[] coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        //coin 3부터 시작한다고 쳐보자
        //dp[0] =1  인 이유는 만약 coin이 5라고 처보자 dp[5]에서 5로 만들 수 있는 경우는 5 하나인 경우 무조건 됨!
        //                                      따라서 dp[5 - coin] = dp[0] 이고 dp[0] =1을 보장해야함
        //dp[1] 0 dp[2] 0 dp[3] 0 dp[4] 0
        //dp[1] 0 dp[2] 0 dp[3] = dp[3] + dp[3-3]  dp[4] = dp[4] + dp[1]
        dp[0] =1;
        for(int i=0; i<n; i++){
            for(int j=1; j<k+1; j++){
                if(j >= coin[i]){
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[k]);

    }
}
