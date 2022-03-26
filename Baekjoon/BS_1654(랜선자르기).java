import java.io.*;
import java.util.*;

class Main{
    static long[] lan;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int k = Integer.parseInt(str[0]);
        long n = Integer.parseInt(str[1]);
        lan = new long[k];
        for(int i=0; i<k; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        long left=1;
        long right=lan[k-1];
        long maxSize=0;
        while(left <= right){
            long mid = (left + right )/2;
            //mid 가 최대 랜선 길이가 될것임
            int count=0;
            for(int i=0; i<k; i++){
                count += lan[i] / mid;
            }
            if(count >= n){
                maxSize = mid;
                left = mid +1;
            }
            else if(count < n){
                right = mid -1;
            }
        }
        System.out.println(maxSize);
    }
}
