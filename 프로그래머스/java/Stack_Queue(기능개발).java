import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<speeds.length; i++){
            int workDay = (int)Math.ceil(((double)(100-progresses[i])/speeds[i]));
            q.offer(workDay);
        }
        
        while(!q.isEmpty()){
            int current = q.poll();
            int count =1;
            while(q.peek()!=null && q.peek() <= current){
                    count++;
                    q.poll();
              }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
