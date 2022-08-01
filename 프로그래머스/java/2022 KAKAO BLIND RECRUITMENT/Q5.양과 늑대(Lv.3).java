import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    static int size;
    static boolean[] visited;
    public int solution(int[] info, int[][] edges) {
        size = info.length;

        ArrayList<Integer>[] list = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0; i<size; i++){
            list[i] = new ArrayList<>();
        }
        //edges에서 인접리스트 만들기
        for(int i=0; i<edges.length; i++){
            int node = edges[i][0];
            int subNode = edges[i][1];
            list[node].add(subNode);
        }
        System.out.println(size);
        /*for(int i=0; i<list.length; i++){
            for(int j=0; j<list[i].size(); j++){
                System.out.println("list "+i+" : "+list[i].get(j));
            }
        }*/
        visited[0] = true;
        dfs(0, 1, 1,0, list, info);




        return max;
    }
    public void dfs(int n, int depth, int sheep, int wolf, ArrayList<Integer>[] list, int[] info){
        //depth
        max = Math.max(max, sheep);
        
        if(depth == size){
            //System.out.println("들림");
            return;
        }
        if(sheep <= wolf){
            return;
        }
        for(int i=0; i<list.length; i++){
            if(visited[i]){
                for(int j=0; j<list[i].size(); j++){
                    int next = list[i].get(j);
                    if(!visited[next]){
                        visited[next] = true;
                        if(info[next]==0) dfs(next, depth+1, sheep+1, wolf, list, info);
                        else dfs(next, depth+1, sheep, wolf+1, list, info);
                        visited[next] = false;
                    }
                }
            }
        }

    }
}
