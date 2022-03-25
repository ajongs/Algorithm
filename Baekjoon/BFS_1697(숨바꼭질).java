import java.io.*;
import java.util.*;

class Main{
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int answer=Integer.MAX_VALUE;
        int max_size = 100001;

        visited = new boolean[max_size];
        //Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(n, 0));
        visited[n] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x==k){
                answer = Math.min(answer, cur.sec);
                break;
            }

            int[] dx = {-1, 1};
            for(int i=0; i<2; i++){
                int nx = cur.x + dx[i];
                if(nx>=0 && nx<max_size && !visited[nx]){
                    visited[nx] = true;
                    q.offer(new Node(nx, cur.sec+1));
                }
            }
            int nx = cur.x*2;
            if(nx>=0 && nx<max_size && !visited[nx]){
                visited[nx] =true;
                q.offer(new Node(nx, cur.sec+1));
            }

        }
        System.out.println(answer);
    }
    static class Node implements Comparable<Node>{
        int x;
        int sec;
        Node(int x, int sec){
            this.x =x;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node node) {
            return this.sec - node.sec;
        }
    }
}
