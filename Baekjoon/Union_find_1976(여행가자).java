import java.io.*;
import java.util.*;
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=1; i<=n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                if(str[j].equals("1")){
                    union(i, j+1);
                }
            }
        }
        String[] str = br.readLine().split(" ");
        int firstNum = Integer.parseInt(str[0]);
        int findNum = find(firstNum);
        for(int i=1; i<m; i++){
            int num = Integer.parseInt(str[i]);
            if(findNum != find(num)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int x1 ,int x2){
        x1 = find(x1);
        x2 = find(x2);

        if(x1 != x2){
            if(x1 < x2){
                parent[x2] = x1;
            }
            else{
                parent[x1] = x2;
            }
        }
    }
}
