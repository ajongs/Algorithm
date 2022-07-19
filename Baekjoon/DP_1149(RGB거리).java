import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main{
    static int[][] dp;
    //0 R //1 G //2 B
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp =new int[n][3];
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int g = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);

            list.add(new int[]{r,g,b});
        }
        dp[0][0] = list.get(0)[0];
        dp[0][1] = list.get(0)[1];
        dp[0][2] = list.get(0)[2];

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                int beforeColor;
                if(dp[i-1][(j+1)%3] < dp[i-1][(j+2)%3]){
                    beforeColor = (j+1)%3;
                }
                else{
                    beforeColor = (j+2)%3;
                }
                dp[i][j] = dp[i-1][beforeColor] + list.get(i)[j];
            }
        }
        int answer =Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            answer = Math.min(answer, dp[n-1][i]);
        }
        System.out.println(answer);
    }
}
