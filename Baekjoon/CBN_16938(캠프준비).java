import java.io.*;
import java.util.*;
public class Main{
    static int count=0;
    static int n;
    static int l;
    static int r;
    static int x;
    static List<Integer> output = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        l = Integer.parseInt(str[1]);
        r = Integer.parseInt(str[2]);
        x = Integer.parseInt(str[3]);
        str = br.readLine().split(" ");
        int[] A = new int[str.length];
        for(int i=0 ; i<str.length; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        visited = new boolean[str.length];
        findMethod(A,0,0,0);

        System.out.println(count);
    }
    public static void findMethod(int[] A, int depth, int sum, int start){
        if(depth > A.length) return;
        if(sum >= l && sum <= r){
            Collections.sort(output);
            if(output.get(output.size()-1) - output.get(0) >= x){
                count++;
            }
        }
        for(int i=start; i<A.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output.add(A[i]);
                findMethod(A, depth+1, sum+A[i], i+1);
                output.remove((Integer) A[i]);
                visited[i] = false;
            }
        }

    }
}
