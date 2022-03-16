class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        Pair[] pair = new Pair[lines.length];
        int index =0;
        for(String times : lines){
            String[] temp = times.split(" ");
            String[] splitTemp = temp[1].split(":");
            int hour = Integer.parseInt(splitTemp[0]);
            int min = Integer.parseInt(splitTemp[1]);
            int sec = Integer.parseInt(splitTemp[2].split("\\.")[0])*1000 + Integer.parseInt(splitTemp[2].split("\\.")[1]);
            
            int endMs = hour*3600*1000 + min*60*1000 + sec;

            
            String processTime = temp[2].substring(0, temp[2].length()-1);
            int startMs=0;
            if(processTime.contains(".")){
                startMs = endMs - (Integer.parseInt(processTime.split("\\.")[0])*1000 +Integer.parseInt(processTime.split("\\.")[1]))+1;   
            }else{
                startMs = endMs - Integer.parseInt(processTime)*1000 +1;
            }

            
            pair[index++] = new Pair(startMs, endMs);

        }

        for(Pair p : pair){
            answer = Math.max(answer, count(p.start, pair));
            answer = Math.max(answer, count(p.end, pair));
        }
        

        return answer;
    }
    public static int count(int start, Pair[] pair){
        int count=0;
            for(int i=0; i<pair.length; i++){
                if(start > pair[i].end || start+1000 <= pair[i].start ) continue;
                
                count ++;
                
            }
        return count;
    }
    static class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
