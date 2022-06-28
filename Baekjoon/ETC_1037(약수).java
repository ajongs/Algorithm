import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] array = new int[n];
        
        String[] str = br.readLine().split(" ");
        if(n==1){
            int answer = Integer.parseInt(str[0]);
            System.out.println(answer*answer);
            return;
        }
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(array);
        System.out.println(array[0]*array[n-1]);
    }
}
