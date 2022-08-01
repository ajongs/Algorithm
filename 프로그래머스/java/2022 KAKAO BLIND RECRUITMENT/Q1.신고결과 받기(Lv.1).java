import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<n; i++){
            indexMap.put(id_list[i], i);
        }
        
        int[][] reportArr = new int[n][n];
        int[] myReport = new int[n];
        for(int i=0; i<report.length; i++){
            String[] temp = report[i].split(" ");
            int row = indexMap.get(temp[0]);
            int column = indexMap.get(temp[1]);
            
            if(reportArr[row][column]==0){
                reportArr[row][column]++;
                myReport[column]++;
            }
        }
        int[] answer = new int[n];
        for(int j=0; j<n; j++){
            if(myReport[j] >= k){
                for(int i=0; i<n; i++){
                    if(reportArr[i][j] ==1){
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
        
        
    }
}
