
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][2];
        int[] dp = new int[n+2];
        for(int i=0; i<n; i++){
            String[] str= br.readLine().split(" ");

            arr[i+1][0] = Integer.parseInt(str[0]);
            arr[i+1][1] = Integer.parseInt(str[1]);
        }
        int max = -1;
        for(int i=1; i<n+2; i++){
            int time = arr[i][0];
            int price = arr[i][1];
            //dp[i]번째 까지의 최대값을 저장
            max = Math.max(max, dp[i]);
            
            if(i+time < n+2){
              // i+time 전까지 완료된 dp들중 가장 큰값 + 현재 날짜에서 일을 받은 값
              // 원래의 dp[i+time] 에 들어있던 값중 더 큰값으로 초기화 
                dp[i+time] = Math.max(max+price, dp[i+time]);
            }
        }
        System.out.println(max);
    }
}
