class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%k);
            n /=k;
        }
        sb.reverse();
        String[] str = sb.toString().split("0|00");

        int answer = 0;
        for(int i=0; i<str.length; i++){
            if(str[i].equals("")) continue;
            long num = Long.parseLong(str[i]);
            
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    public boolean isPrime(long num){
        if(num==1) return false;
        for(int j=2; j<=Math.sqrt(num); j++){
            if(num==j) continue;
            if(num % j==0) return false;
        }
        return true;
    }
}
