import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class Main{
    static int[] time;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        time = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            time[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(time);

        int answer=0;
        int pre=0;
        for(int i=0; i<n; i++){
            answer += (pre + time[i]);
            pre += time[i];
        }

        System.out.println(answer);
    }
}
