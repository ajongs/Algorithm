import java.io.*;
import java.util.*;
class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt_2 = 0;
        int cnt_5 = 0;
  
        for(int i=2; i<n+1; i++){
            int cur = i;
            
            while(cur%2==0){
                cnt_2++;
                cur /= 2;
            }
            
            while(cur%5==0){
                cnt_5++;
                cur /= 5;
            }
        }
        
        System.out.println(Math.min(cnt_2, cnt_5));
    }
}
