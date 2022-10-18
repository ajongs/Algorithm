import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int[] arr = new int[n+1];
        str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int start=0;
        int end=0;
        int sum=0;
        int answer=Integer.MAX_VALUE;

        while(start<=n && end<=n){
            //end는 sum값에 해당하는 것 보다 +1
            if(sum < s ) sum += arr[end++];
            else {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            }
        }
        if(answer==Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
