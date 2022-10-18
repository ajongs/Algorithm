import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        for(int i=0; i<str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int s=0;
        int e=arr.length -1;
        int sum=0;
        int answer=0;
        while(s<e){
            sum = arr[s]+ arr[e];
            if(sum < x){
                s++;
            }else{
                if(sum == x) answer++;
                e--;
            }
        }
        System.out.println(answer);
    }
}
