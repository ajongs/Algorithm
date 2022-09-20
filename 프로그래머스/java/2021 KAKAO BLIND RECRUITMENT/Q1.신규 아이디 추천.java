class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        for(int i=0; i<new_id.length(); i++){
            char cur = new_id.charAt(i);
            if(cur >= 'a' && cur<='z') sb.append(cur);
            else if(cur >= '0' && cur<='9') sb.append(cur);
            else if(cur == '-' || cur == '_' || cur == '.') sb.append(cur);
        }
        //3단계
        for(int i=0; i<sb.length()-1; i++){
            if(sb.charAt(i) == '.'){
                int next = i+1;
                while(next < sb.length() && sb.charAt(next) == '.') {
                    sb.deleteCharAt(next);
                }
            }
        }
        //4단계
        if(sb.charAt(0)=='.') sb.deleteCharAt(0);
        if(sb.length() > 1 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);

        //5단계
        if(sb.toString().equals("") || sb.toString().equals(null)){
            sb.append("a");
        }
        //6단계
        if(sb.length()>= 16){
            sb.delete(15, sb.length());
            if(sb.length() > 1 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() <= 2){
            char c = sb.charAt(sb.length()-1);
            int count = 3 - sb.length();
            for(int i=0; i<count; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
        
}
