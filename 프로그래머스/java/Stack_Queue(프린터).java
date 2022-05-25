import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            pq.offer(priorities[i]);
        }
        
        int request = priorities[location];.
        
        while(!pq.isEmpty()){
            //계속 priorities 계속 반복문 돌리면서 우선순위 큐의 값과 같을 때 우선순위 큐 poll;
            //큐가 빌 때까지 반복하다가 i번째가 LOCATION에 오면 ANSWER을 출력
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    if(i==location){
                        pq.poll(); //안해도 상관은 없음
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        
        return -1;
        
    }
}
