class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            dfs(nums, i, 0, 0, new ArrayList<>());
        }
        return answer;
    }
    public void dfs(int[] nums, int count, int depth, int index, List<Integer> result) {
        if (count == depth) {
            answer.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            dfs(nums, count, depth + 1, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
}
