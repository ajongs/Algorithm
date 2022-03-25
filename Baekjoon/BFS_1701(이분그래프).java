import java.io.*;
import java.util.*;

class Main{
    static int v;
    static int e;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());


        for(int i=0; i<k; i++){
            String[] temp = br.readLine().split(" ");
            v = Integer.parseInt(temp[0]);
            e = Integer.parseInt(temp[1]);
            list = new ArrayList[v+1];
            for(int z=1; z<v+1; z++){
                list[z] = new ArrayList<>();
            }
            for(int j=0; j<e; j++){
                String[] vertex = br.readLine().split(" ");
                list[Integer.parseInt(vertex[0])].add(Integer.parseInt(vertex[1]));
                list[Integer.parseInt(vertex[1])].add(Integer.parseInt(vertex[0]));
            }
            bfs();
        }
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] type = new int[v+1];
        for(int i=1; i<v+1; i++){
            if(type[i]==0){
                type[i] = 1;
                q.offer(i);
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : list[cur]){
                    if(type[next]==0){
                        if(type[cur]==1)
                            type[next]=2;
                        else
                            type[next] =1;
                        q.offer(next);
                    }
                    else if(type[next] == type[cur]){
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
