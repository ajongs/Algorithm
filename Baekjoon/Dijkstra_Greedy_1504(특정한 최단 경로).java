import java.io.*;
import java.util.*;


class Main {
    static int n; //정점의 개수
    static int e; //간선의 개수
    static List<int[]>[] list;
    final static int INF = 200000000; //200,000 * 1000
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        e = Integer.parseInt(str[1]);
        list = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            str = br.readLine().split(" ");
            list[Integer.parseInt(str[0])].add(new int[]{Integer.parseInt(str[1]), Integer.parseInt(str[2])});
            list[Integer.parseInt(str[1])].add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[2])});
        }
        str = br.readLine().split(" ");
        int v1 = Integer.parseInt(str[0]);
        int v2 = Integer.parseInt(str[1]);
        //1. 1에서 시작해서 N1 N2 N 으로 가는  최단 경로
        //2. 1에서 시작해서 N2 N1 N 으로 가는 최단경로 2가지가 있음
        //둘중에 더 빠르걸로 가야함.
        //1 시뮬레이션
        int simul_1 = dijkstra(1,v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        //2 시뮬레이션
        int simul_2 = dijkstra(1,v2) + dijkstra(v2,v1)+ dijkstra(v1,n);

        //경로가 없는 경우?
        if(simul_1 >= INF && simul_2 >= INF){
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(simul_1, simul_2));


    }
    static int dijkstra(int start, int end){
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        Arrays.fill(dist, INF);

        dist[start] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curDest = curNode.dest;
            int curCost = curNode.cost;
            //이게 방문검사이기도 하고 현재의 값이 더 크다면 이 경로는 최단경로가 아님.
            if(dist[curDest] < curCost){
                continue;
            }
            for(int[] info : list[curDest]){
                //여기서 이제 다시 검사할곳 보고
                int nextDest = info[0];
                int nextCost = info[1];
                //dist 갱신까지 함
                if(dist[nextDest] > curCost + nextCost){
                    dist[nextDest] = curCost + nextCost;
                    q.offer(new Node(nextDest, dist[nextDest]));
                }
            }
        }

        return dist[end];

    }
    static class Node implements Comparable<Node>{
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost == o.cost){
                return this.dest - o.dest;
            }
            return this.cost - o.cost;
        }
    }
}
