import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<Pos>[] adj;
    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int p = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < p; i++) {
            str = br.readLine().split(" ");

            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);

            adj[u].add(new Pos(v, w));
            adj[v].add(new Pos(u, w));
        }

        //이분탐색으로 x원 이하일때 k이하를 만족하는지 체크
        int l=0;
        int r=1000000;
        int ans =-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(dijkstra(mid)){
                ans = mid;
                r = mid - 1;
            }else
                l = mid + 1;
        }
        System.out.println(ans);
    }
    public static boolean dijkstra(int x){
        Queue<Pos> q = new PriorityQueue<>();
        for (int i = 2; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        q.offer(new Pos(1,0));
        while(!q.isEmpty()){
            Pos cur = q.poll();

            for (Pos pos : adj[cur.v]) {
                int w = pos.w > x ? 1 : 0;
                if(dist[pos.v] > cur.w + w){
                    dist[pos.v] = cur.w + w;
                    q.offer(new Pos(pos.v, cur.w+w));
                }

            }
        }
        return dist[n] <= k;

    }
    static class Pos implements Comparable<Pos>{
        int v;
        int w;
        public Pos(int v, int w){
            this.v =v ;
            this.w=w;
        }

        @Override
        public int compareTo(Pos o1){
            return this.w - o1.w;
        }
    }
}
