import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int union =0;
        Set<String> set = new HashSet<>();
        str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            set.add(str[i]);
        }
        str = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            if(set.contains(str[i]))  union++;
            set.add(str[i]);
        }
        System.out.println(set.size()-union);
    }
}
