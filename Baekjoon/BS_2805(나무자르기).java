import java.io.*;
import java.util.*;

class Main{
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long m = Long.parseLong(str[1]);

        tree = new long[n];

        String[] str2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            tree[i] = Long.parseLong(str2[i]);
        }

        Arrays.sort(tree);
        long left = 0;
        long right = tree[n-1];

        while(left <= right){
            long mid = (left + right)/2;

            long count =0;
            for(int i=0; i<n; i++){
                if(tree[i]-mid <=0) continue;
                count += tree[i]-mid;
            }

            if(count >= m){
                left = mid + 1;
            }
            else if(count < m){
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
