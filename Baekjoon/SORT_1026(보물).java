import java.util.*;
import java.io.*;
class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }
        int result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<n; i++){
            result += a[i]*b[n-1-i];
        }
        System.out.println(result);
    }
}
