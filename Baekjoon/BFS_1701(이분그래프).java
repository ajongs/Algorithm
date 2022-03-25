import java.io.*;
import java.util.*;

class Main{
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            String[] temp = br.readLine().split(" ");
            int v = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            int[][] adj = new int[v+1][v+1];
            for(int j=0; j<e; j++){
                String[] vertex = br.readLine().split(" ");
                adj[Integer.parseInt(vertex[0])][Integer.parseInt(vertex[1])] =1;
                adj[Integer.parseInt(vertex[1])][Integer.parseInt(vertex[0])] =1;
            }
            checkBipartiteGraph(v,e,adj);
        }
    }
    public static void checkBipartiteGraph(int v, int e, int[][] adj){
        visited = new boolean[v+1];
        boolean result = true;
        for(int i=1; i<v+1; i++){
            if(!visited[i]){
                if(!bfs(v, i, adj))
                    result = false;
            }
        }
        if(result)
            System.out.println("YES");

    }
    public static boolean bfs(int v, int start, int[][] adj) {
        boolean[] check = new boolean[v+1];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, true));
        visited[start] = true;
        check[start] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=1; i<v+1; i++){
                if(i==cur.vertex) continue;
                if(adj[cur.vertex][i]==1){
                    if(!visited[i]){
                        visited[i] = true;
                        check[i] = !cur.type;
                        q.offer(new Node(i, !cur.type));
                    }
                    else{
                        if(check[i] == cur.type){
                            System.out.println("NO");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    static class Node{
        int vertex;
        boolean type;
        Node(int vertex, boolean type){
            this.vertex = vertex;
            this.type = type;
        }
    }
}
