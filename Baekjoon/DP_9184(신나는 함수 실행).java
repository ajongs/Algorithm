import java.io.*;


class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a==-1 && b==-1 && c==-1) break;


            System.out.println("w("+a+", "+b+", "+c+") = " + w(a,b,c));
        }



    }

    static int w(int a, int b, int c) {


        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            if (dp[20][20][20] > 0) {
                return dp[20][20][20];
            }
            return dp[20][20][20] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            if (dp[a][b][c] > 0) {
                return dp[a][b][c];
            }
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            if(dp[a][b][c]>0){
                return dp[a][b][c];
            }
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }
}
