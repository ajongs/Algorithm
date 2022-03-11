import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(numbers[0],0));
        q.offer(new Point(-1*numbers[0],0));
        while(!q.isEmpty()){
            Point cp = q.poll();
            
            if(cp.index == numbers.length-1){
                if(cp.item == target){
                    answer++;
                }
            }
            else{
                int nextIndex = cp.index + 1;
                q.offer(new Point(cp.item + numbers[nextIndex], nextIndex));
                q.offer(new Point(cp.item - numbers[nextIndex], nextIndex));
            }
            
        }
        
        return answer;
        //target <= 1000
    }
    class Point{
        int item;
        int index;
        
        Point(int item, int index){
            this.item = item;
            this.index = index;
        }
    }
}
