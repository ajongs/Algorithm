import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] sum = new int[n+1][n+1];

        for(int i=1; i<n+1; i++){
            str = br.readLine().split(" ");
            for(int j=1; j<n+1; j++){
                sum[i][j] = sum[i][j-1] + Integer.parseInt(str[j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);

            int answer=0;
            for(int j=x1; j<=x2; j++){
                answer += (sum[j][y2] - sum[j][y1-1]);
            }

            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
