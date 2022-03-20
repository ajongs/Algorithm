class Solution {
    public String solution(String sentence) {
        String answer = "";
        char rule1;
        char rule2;
        String used="";
        //System.out.println(sentence);
        for(int i=0; i<sentence.length(); i++){
            int index = i+1;
            //System.out.println("i = " + i);
            if(sentence.charAt(i)-'a'<0){
                //대문자일때
                answer += Character.toString(sentence.charAt(i));
                //System.out.println("answer = "+answer);
                rule1=sentence.charAt(index);
                String strRule1 = Character.toString(rule1);
                if(used.contains(strRule1)){
                    return "invalid";
                }
                used += strRule1;
                while(index<sentence.length() && sentence.charAt(index)==rule1){
                    answer += Character.toString(sentence.charAt(index+1));
                    index+=2;
                }
                if(index-1<sentence.length()-1){
                    answer += " ";
                }
                i=index-1;
            }
            else{
                rule2 = sentence.charAt(i);
                String strRule2 = Character.toString(rule2);
                if(used.contains(strRule2)){
                    return "invalid";
                }
                used += strRule2;
                while(index<sentence.length() && sentence.charAt(index)!=rule2){
                    if(sentence.charAt(index)-'a'<0){
                        //대문자면 answer 추가
                        answer += Character.toString(sentence.charAt(index));
                    }
                    index++;
                }
                if(index<sentence.length()-1){
                    answer += " ";
                }
                i = index;
            }
            //65 A
            //97 a
        }
        return answer;
    }
}
