import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int k = Integer.parseInt(br.readLine());

            int[] pages = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            String[] str = br.readLine().split(" ");
            //구간합 구하기
            for(int page=1; page<=k; page++){
                pages[page] = Integer.parseInt(str[page-1]);
                sum[page] = sum[page-1] + pages[page];
                dp[page][page] = 0; //dp[i][j] i==j일때는 더해지면 안됨. 그래서 0으로 초기화 
            }

            for(int i=1; i<k; i++){
                dp[i][i+1] = pages[i] + pages[i+1];
            }

            for(int n=2; n<=k ;n++){ //몇개를 묶을 지
                for(int s=1; s+n<=k; s++){//어디서 부터 시작할 지
                    int e = s+n;
                    dp[s][e] = Integer.MAX_VALUE;
                    for(int divide = s; divide<e; divide++){
                        dp[s][e] = Math.min(dp[s][e], dp[s][divide] + dp[divide+1][e]+ sum[e] - sum[s-1]);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}
