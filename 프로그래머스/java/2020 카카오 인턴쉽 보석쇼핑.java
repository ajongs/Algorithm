import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int size = set.size();
        int s=0;
        int e=0;
        int[] answer = new int[2];
        int count=Integer.MAX_VALUE;
        while(true){
            if(map.size() == size){
                if(count > e-s){
                    count = e-s;
                    answer[0] = s+1;
                    answer[1] = e;
                }
                if(map.get(gems[s])==1)
                    map.remove(gems[s]);
                else{
                    map.put(gems[s], map.get(gems[s])-1);
                }
                s++;
            }
            else if(e == gems.length)
                break;
            else{
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
                e++;
            }
            
            
        }
        return answer;
    }
}
