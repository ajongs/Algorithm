import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] temp = new int[n];
        int[] diff = new int[n-1];
        for(int i=0; i<n; i++){
            temp[i] =  Integer.parseInt(str[i]);
        }

        Arrays.sort(temp);

        for(int i=0; i<n-1; i++){
            diff[i] = temp[i+1] - temp[i];
        }

        Arrays.sort(diff);

        int solo = k-1;
        for(int i=diff.length-1; i>diff.length-1-solo ; i--){
            diff[i] = 0;
        }

        int answer =0;
        for(int i=0; i< diff.length; i++){
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
