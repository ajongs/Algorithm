class Solution {
    public int solution(String s) {
        int answer = s.length();
    
        for(int i=1; i<=s.length()/2; i++){
            String current = s.substring(0,i);
            int count=1;
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<=s.length(); j+=i){
                String next = s.substring(j, j+i > s.length() ? s.length() : j+i);
                if(current.equals(next)){
                    count++;
                    continue;
                }
                
                //여기서 부터는 다음 스트링이 같지 않을때 수행
                if(count>1){
                    sb.append(count);
                }
                sb.append(current);
                current = next;
                count=1;
            }
            sb.append(current);
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
    
}
