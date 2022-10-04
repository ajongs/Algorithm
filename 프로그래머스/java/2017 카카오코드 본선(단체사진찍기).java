class Solution {
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visited= new boolean[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {
        permutation("", 0, 8, data, n);
        return answer;
    }
    public void permutation(String str,int depth, int count, String[] data, int n){
        if(depth==count){
            //여기서 이제 제약조건 확인해야지 
            if(check(str, data, n)){
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(str+friends[i], depth+1, count, data, n);
                visited[i] = false;
            }
        }
    }
    public boolean check(String str, String[] datas, int n){
        for(String data : datas){
            String[] d = data.split("");
            
            int s1 = str.indexOf(data.charAt(0));
            int s2 = str.indexOf(data.charAt(2));
            int count= Math.abs(s1-s2);
            int res = data.charAt(4) - '0' + 1;
            if(data.charAt(3)=='<'){
                if(count >= res)
                    return false;
            }else if(data.charAt(3)=='>'){
                if(count <= res)
                    return false;
            }else{ //= 
                if(count != res)
                    return false;
            }
        }
        return true;
    }
}
