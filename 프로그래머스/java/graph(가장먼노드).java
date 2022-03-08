import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int answer = 0;
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(i, new ArrayList<>());
        }


        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }


        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int v = q.poll();

            for(int node : graph.get(v)){
                if(dist[node]==0){
                    dist[node] = dist[v]+1;
                    q.offer(node);
                }
            }
        }

        int max=0;
        for(int i=2; i<=n; i++){
            max = Math.max(dist[i], dist[max]);
        }

        for(int i=2; i<=n; i++){
            if(dist[i]==max){
                answer++;
            }
        }
        return answer;
    }
}
