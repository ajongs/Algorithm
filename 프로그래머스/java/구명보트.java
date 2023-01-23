import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int preIndex = 0;
        for (int i = people.length - 1; i >= preIndex ; i--) {
            if (people[preIndex] + people[i] <= limit) {
                preIndex++;
            }
            answer++;
        }
        return answer;
    }
}
