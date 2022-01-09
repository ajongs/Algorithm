import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] D = new int[n+1];
        for(int i=1; i<=n; i++){
            D[i] = i; // 1의 제곱의 개수
            for(int j=1; j*j<=i; j++){
                if(D[i] > D[i-j*j]+1)
                    D[i] = D[i-j*j]+1;
            }
        }
        System.out.println(D[n]);
    }
}
