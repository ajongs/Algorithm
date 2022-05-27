import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int time =0;

        //일단 트럭에 있는 무게를 다 넣긴해야해
        //이 무게들 다 넣고 나서도 큐만큼 더 넣어줘야하고

        int roadSum=0;
        for(int i=0; i<truck_weights.length; i++){
            while(true){
                
                if(roadSum + truck_weights[i] <= weight && q.size() +1 <= bridge_length){
                    q.offer(truck_weights[i]);
                    roadSum += truck_weights[i];
                    time++;
                    break;
                }
                else if(q.size()+1 <= bridge_length){
                    q.offer(0);
                    time++;
                }
                else{ // 무게 초과 거나 , 개수 초과인경우
                    int exit = q.poll();
                    roadSum -= exit;
                }
            }
        }
        for(int i=0; i<bridge_length; i++){
            time +=1;
        }
        return time;
    }
}
