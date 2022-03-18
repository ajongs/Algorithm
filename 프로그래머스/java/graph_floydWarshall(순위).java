import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer=0;
        int[][] graph = new int[n][n];
        for(int[] result: results){
            graph[result[0]-1][result[1]-1] = 1;
            graph[result[1]-1][result[0]-1] = -1;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(graph[i][k]==1 && graph[k][j]==1){
                        graph[i][j] =1;
                    }
                    else if(graph[i][k]==-1 && graph[k][j]==-1){
                        graph[i][j] = -1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0 ;j <n; j++){
                if(graph[i][j]==0){
                    count++;
                }
            }
            if(count==1){
                answer++;
            }
        }
        return answer;
    }
}
