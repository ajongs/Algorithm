import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        
        int[] D = new int[n];
        D[0] = A[0];
        for(int i=1; i<n; i++){
            D[i] = Collections.max(Arrays.asList(D[i-1]+A[i], A[i]));
        }
        int ans=D[0];
        for(int i=1; i<n; i++){
            if(ans<D[i])
                ans = D[i];
        }
        System.out.println(ans);
    } 
}
