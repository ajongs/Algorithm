import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n;        
        int[][] d; 
        int[][] A;
        
        for(int i=0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            // 한 열이 뜯겨진 상태를 3가지로 나눔  
            // x o x  
            // x x o
                
            // 0 1 2 로 치환
            d = new int[n+1][3];  // n번째 열의 상태 3가지 중 한개 일 때 값 중 최대 값 저장
            A = new int[2][n+1];  // 해당 스티커들의 순수 값을 저장해놓는 변수
            String[] str1 = br.readLine().split(" ");
            String[] str2 = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                A[0][j] = Integer.parseInt(str1[j-1]);
                A[1][j] = Integer.parseInt(str2[j-1]);
            }
            for(int k=1; k<=n; k++){
                d[k][0] = Collections.max(Arrays.asList(d[k-1][0], d[k-1][1], d[k-1][2]));
                d[k][1] = Collections.max(Arrays.asList(d[k-1][0], d[k-1][2])) + A[0][k];
                d[k][2] = Collections.max(Arrays.asList(d[k-1][0], d[k-1][1])) + A[1][k];
            }
            System.out.println(Collections.max(Arrays.asList(d[n][0], d[n][1], d[n][2])));
        }
        
    }
    
}
