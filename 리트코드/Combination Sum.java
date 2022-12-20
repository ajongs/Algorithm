import java.util.*;
class Solution {
    static List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return answer;
    }
    public void dfs(int[] candidates, int target, int sum, int index, List<Integer> result) {
        if (sum > target) return;
        if (sum == target) {
            answer.add(new ArrayList<>(result));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            result.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], i, result);
            result.remove(result.size() - 1);
        }
    }
}
