
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int v; //정점의 개수
    static int e; //간선의 개수
    static int k; //시작 정점
    static List<int[]>[] list;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        v = Integer.parseInt(str[0]);
        e = Integer.parseInt(str[1]);
        list = new ArrayList[v+1];
        dist = new int[v+1];
        visited = new boolean[v+1];
        for(int i=0; i<v+1; i++){
            list[i] = new ArrayList<>();
            dist[i] = 3000000; //간선 개수 300,000 x 10 (w 최대 10)
        }
        int start = Integer.parseInt(br.readLine());
        for(int i=0; i<e; i++){
            str = br.readLine().split(" ");
            list[Integer.parseInt(str[0])].add(new int[]{Integer.parseInt(str[1]), Integer.parseInt(str[2])});
        }

        bfs(start);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<v+1; i++){
            if(dist[i]==3000000){
                sb.append("INF\n");
            }
            else
                sb.append(dist[i]+"\n");
        }
        System.out.print(sb);
    }
    static void bfs(int start){
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(dist[o1]==dist[o2]){
                    return o1 - o2;
                }
                return dist[o1] - dist[o2];
            }
        });
        q.offer(start);
        dist[start] =0 ;

        //start 부터 시작하는 것 curArr 의 모든 곳을 탐색하며 dis 갱신
        while(!q.isEmpty()){
            int cur = q.poll();

            if(visited[cur]) continue;
            visited[cur] = true;
            for (int[] endArr : list[cur]) {
                int end = endArr[0];
                dist[end] = Math.min(dist[end], dist[cur]+endArr[1]);
                q.offer(end);
            }

        }
    }
}
