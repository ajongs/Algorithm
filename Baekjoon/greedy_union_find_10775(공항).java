import java.io.*;
import java.util.*;
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G+1]; //왜냐 0도 써야함
        for(int i=0; i<G+1; i++){
            parent[i] = i;
        }

        int answer=0;
        for(int i=0; i<P; i++){
            int num = Integer.parseInt(br.readLine());
            int gate = find(num);

            if(gate == 0){
                break;
            }
            answer++;
            union(gate, gate -1);
        }
        System.out.println(answer);
    }
    static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] =find(parent[x]);
    }
    static void union(int x, int y){
        int findX = find(x);
        int findY = find(y);
        //y가 더작음
        if(findX != findY){
            parent[findX] = findY;
        }
    }
}
