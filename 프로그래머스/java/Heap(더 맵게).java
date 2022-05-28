import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int count=0;
        boolean isPossible=false;
        while(!pq.isEmpty()){
            int sum=0;
            int first = pq.poll();
            sum += first;
            if(sum < K){
                if(pq.isEmpty()){
                    return -1;
                }
                int second = pq.poll();
                sum += second*2;
                count++;
                pq.offer(sum);
            }
            
            if(sum > K){
                sum =0;    
            }
        }
        return count;
    }
}
