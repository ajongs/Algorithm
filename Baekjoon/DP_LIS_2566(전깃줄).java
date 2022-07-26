import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[n];
        int[] d = new int[n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        int idx=0;
        for (Integer value : map.values()) {
            a[idx++] = value;
        }
        for(int i=0; i< a.length; i++){
            d[i] = 1;
            for(int j=0; j<i; j++){
                if(a[i] > a[j] && d[i] < d[j] +1){
                    d[i] = d[j]+1;
                }
            }
        }
        int max =0;
        for (int i : d) {
            max = Math.max(max, i);
        }
        System.out.println(n-max);
    }
}
