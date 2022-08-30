import java.io.*;
import java.util.*;
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            if(str[0].equals("0")){ //union 연산
                int x = Integer.parseInt(str[1]);
                int y = Integer.parseInt(str[2]);
                union(x, y);
            }
            else{ //find 연산
                int x = Integer.parseInt(str[1]);
                int y = Integer.parseInt(str[2]);
                int rootX = find(x);
                int rootY = find(y);
                if(rootX == rootY){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        //같으면 이미 같은 집합 종료
        //같지않으면 아래와 같이 작은 집합을 큰집합으로 넣어라?
        //근데 우린 경로압축을 했으니 의미가 없기는함
        if(x!=y){
            parent[x] = y;
        }
    }
}
