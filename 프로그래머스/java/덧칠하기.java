class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int maxIndex = 0;
        for(int index : section) {
            if (maxIndex <= index) {
                maxIndex = m + index;
                answer++;
            }
        }
        return answer;
    }
}
