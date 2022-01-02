import java.io.*;
import java.util.*;

class Main{
    static int[][] d;
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1][3];
        A = new int[n+1];
        
        for(int i=1; i<=n; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        
        //d[n][l] , n번째잔이 l번째로 연속 마신 횟수
        for(int i=1; i<=n; i++){
          List<Integer> list = Arrays.asList(d[i-1][0], d[i-1][1], d[i-1][2]);
          d[i][0] = Collections.max(list);
          d[i][1] = d[i-1][0] + A[i];
          d[i][2] = d[i-1][1] + A[i];
        }
        System.out.println(Collections.max(Arrays.asList(d[n][2], d[n][1], d[n][0])));
        
    }
}
