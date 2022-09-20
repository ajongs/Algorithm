import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[][] dist;
    final static int INF = Integer.MAX_VALUE;
    static ArrayList<int[]>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        visited = new boolean[n+1][n+1];
        dist = new int[n+1][n+1];
        
        adj = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
            for(int j=1; j<n+1; j++){
                dist[i][j] = INF;
            }
        }
        //인접리스트 fares로 초기화
        for(int[] fare : fares){
            int v1 = fare[0];
            int v2 = fare[1];
            int weight = fare[2];
            
            adj[v1].add(new int[]{v2, weight});
            adj[v2].add(new int[]{v1, weight});            
        }
        
        //다익스트라
        for(int i=1; i<n+1; i++){
            dijkstra(i);
        }
        
        
        
        //완전탐색으로 찾아내기? 
        int answer =Integer.MAX_VALUE;
        for(int i=1; i<n+1; i++){
            int result = dist[s][i] + dist[a][i] +dist[b][i];
            answer = Math.min(answer, result);
        }
        
        
        return answer;
    }
    public void dijkstra(int start){
        Queue<int[]> pq=  new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        dist[start][start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int v = cur[0];
            int curWeight = cur[1];
            
            if(dist[start][v] < curWeight) continue; //이것이 실패원인
            
            for(int[] next : adj[v]){
                int nextV = next[0];
                int nextWeight = next[1];
                int sumWeight = curWeight + nextWeight;
                
                if(dist[start][nextV] > sumWeight){
                    dist[start][nextV] = sumWeight;

                    pq.offer(new int[]{nextV, sumWeight});
                }
                
            }
        }
    }
}
