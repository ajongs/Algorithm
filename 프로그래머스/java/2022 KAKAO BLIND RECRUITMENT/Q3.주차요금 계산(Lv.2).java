import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        //records 시각, 차량번호, 내역 공백 구분
        
        TreeSet<String> set = new TreeSet<>();
        for(int i=0; i<records.length; i++){
            String[] str = records[i].split(" ");
            set.add(str[1]);
        }
        Map<String, Integer> indexMap = new HashMap<>();
        int idx=0;
        for(String key : set){
            indexMap.put(key, idx++);
        }
        
        int[] time = new int[set.size()];
        int[] answer = new int[set.size()];
        
        //주차 계산
        boolean[] visited = new boolean[records.length];
        for(int i=0; i<records.length; i++){
            if(visited[i]) continue;
            String[] temp = records[i].split(" ");
            
            if(temp[2].equals("IN")){
                visited[i] = true;
                int inTime = convertTime(temp[0]);
                int outTime =0;
                int myIndex = indexMap.get(temp[1]);
                for(int j=0; j<records.length; j++){
                    String[] temp2 = records[j].split(" ");
                    if(!visited[j] && temp2[1].equals(temp[1]) &&temp2[2].equals("OUT")){                        
                        outTime = convertTime(temp2[0]);
                        time[myIndex] += outTime - inTime;
                        visited[j] = true;
                        break;
                        
                    }
                }
                
                if(outTime==0){
                    outTime = convertTime("23:59");
                    time[myIndex] += outTime - inTime;
                }
            }
        }
        //fees 관련 
            //fee 기본시간 기본요금 단위시간 단위요금 순
            for(int i=0; i<answer.length; i++){
                answer[i] += fees[1]; //일단 기본 요금 추가
                if(time[i]> fees[0]){ //기본 시간 초과 했다면
                    answer[i] += (int)Math.ceil((double)(time[i] - fees[0])/fees[2]) * fees[3];
                }                    
            }
        return answer;
    }
    public int convertTime(String s){
        String[] str = s.split(":");
        int hour = Integer.parseInt(str[0]) * 60;
        int minute = Integer.parseInt(str[1]);
        return hour+minute;
    }
}
