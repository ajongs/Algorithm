import java.util.*;
class Solution {
    public String[] solution(String[] record) {
       String[] answer = {};
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> list = new ArrayList<>();
        for(String s: record){
            String[] temp = s.split(" ");
            if(temp[0].equals("Enter") || temp[0].equals("Change")){
                map.put(temp[1], temp[2]);
            }
        }

        for(String s : record){
            String[] temp = s.split(" ");
            if(temp[0].equals("Change")){
                continue;
            }
            if(temp[0].equals("Enter")){
                sb.append(map.get(temp[1])+"님이 들어왔습니다.\n");
            }
            else{
                sb.append(map.get(temp[1])+"님이 나갔습니다.\n");
            }
        }
        answer = sb.toString().split("\\n");
        return answer;
    }
}
