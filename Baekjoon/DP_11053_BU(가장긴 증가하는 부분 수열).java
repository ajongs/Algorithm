import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] d = new int[n];
        int answer=0;

        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        
        for(int i=0; i<n; i++){
            d[i] = 1;
            for(int j=0; j<i; j++){
                if(A[i]>A[j] && d[i] < d[j]+1){
                    d[i] = d[j]+1;
                }
            }
        }
        for(int i=0; i<n; i++){
          if(answer < d[i])
            answer =d[i];
        }
        System.out.println(answer);

    }
}
