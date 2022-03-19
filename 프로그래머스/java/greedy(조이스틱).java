class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index=0;
        int move= length-1;
        
        for(int i=0; i<length; i++){
            //위아래로 알파벳 조작 횟수
            answer += Math.min(name.charAt(i)-'A', 'Z'+1-name.charAt(i));
            
            index=i+1;
            while(index < length && name.charAt(index)=='A'){
                index++;
            }
            
            //순서랑 뒤로 돌아가는거 어떤게 빠른지
            move = Math.min(move, (length-index)*2 + i);
            
            move = Math.min(move, i*2 + (length-index));
            
        }
        return answer + move;
    }
}
