import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];
        int[][] D = new int[n+1][3];
        for(int i=1; i<n+1; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        
        D[1][1]=A[1];
        for(int i=2; i<n+1; i++){
            D[i][1] = Collections.max(Arrays.asList(D[i-2][1], D[i-2][2]))+A[i];
            D[i][2] = D[i-1][1] + A[i];
        }

        if(D[n][1]>D[n][2]){
            System.out.println(D[n][1]);
        }
        else
            System.out.println(D[n][2]);
    }
}
