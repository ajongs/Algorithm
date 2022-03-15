import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        dfs(0,N,number,0);
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
    static void dfs(int depth, int N, int number, int current){
        if(depth>8){
            min = -1;
            return;
        }
        if(current == number){
            min = Math.min(min, depth);
            return;
        }
        int temp=N;
        for(int i=0; i<8-depth; i++){
            int newDepth = depth + i+1;
            dfs(newDepth, N, number, current+temp);
            dfs(newDepth, N, number, current-temp);
            dfs(newDepth, N, number, current*temp);
            dfs(newDepth, N, number, current/temp);
            temp = temp*10+N;

        }
    }
}
