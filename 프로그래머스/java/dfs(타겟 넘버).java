import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer=0;
    public int solution(int[] numbers, int target) {
        
        visited = new boolean[numbers.length];
        
        dfs(0-numbers[0], 0, numbers, target);
        dfs(0+numbers[0], 0, numbers, target);
        
        return answer;
    }
    public void dfs(int sum, int curIndex, int[] numbers, int target){
        if(sum==target && curIndex == numbers.length-1){
            answer++;
            return;
        }
        int nextIndex = curIndex+1;
        if(nextIndex < numbers.length){   
            dfs(sum+numbers[nextIndex], nextIndex, numbers, target);
            dfs(sum-numbers[nextIndex], nextIndex, numbers, target);
        }
    }
}
