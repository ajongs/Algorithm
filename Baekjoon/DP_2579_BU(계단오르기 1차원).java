import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];
        int[] D = new int[n+1];
        for(int i=1; i<n+1; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=1; i<n+1; i++){
            if(i==1){
                D[1] = A[1];
            }
            else if(i==2){
                D[2] = A[1]+A[2];
            }
            else
                D[i] = Collections.max(Arrays.asList(D[i-3]+A[i-1]+A[i], D[i-2]+A[i]));
        }
        
        System.out.println(D[n]);
    }
}
