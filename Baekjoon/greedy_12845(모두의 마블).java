import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        //예를 들어 10 20 30 50 70
        //이 경우엔 10+70, 20+50, 50+30, 70+50
        //10+70 70+50 70+30 70+20
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] L = new int[n];

        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(L);
        int max = L[n-1];
        int result=0;
        for(int i=0; i<n-1; i++){
            result += max + L[i];
        }
        System.out.println(result);
    }
}
