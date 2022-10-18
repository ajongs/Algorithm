import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        int s=0;
        int e=n-1;
        int sum=0;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(s<e){
            sum = arr[s] + arr[e];
            if(min > Math.abs(sum)){ //min값이 갱신되었을때 이거 보다 작은게 있는지 찾아야지
                //근데 이게 sum 이 -값이야 그러면 +값을 늘려줘야지 그니까 s++
                min = Math.abs(sum);
                answer[0] = arr[s];
                answer[1] = arr[e];
            }
            if(sum < 0){
                s++;
            }
            else
                e--;
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
