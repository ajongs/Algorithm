import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        boolean[][] map = new boolean[n+1][n+1];

        for(int i=0; i<edge.length; i++){
            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }

        //bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            //가장 마지막번째로 순회하는 녀석들
            answer = q.size();

            for(int i=0; i<answer; i++){
                int cur = q.poll();

                for(int next = 2; next<n+1; next++){
                    if (visited[next] == true || map[cur][next] ==false ) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return answer;
    }
}
/*
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
}*/
