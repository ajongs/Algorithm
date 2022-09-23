class Solution {
    int[] allWeak;
    int weakCnt;
    int answer= -1;
    public int solution(int n, int[] weak, int[] dist) {
        allWeak = new int[weak.length*2 -1];
        weakCnt = weak.length;
        makeAllWeak(weak, n);
        for(int i=1; i<=dist.length; i++){
            permutation(0, i, new int[i], dist, new boolean[dist.length]);
        }
        return answer;
    }
    public void check(int[] res){
        for(int i=0; i<weakCnt; i++){
            int pos = allWeak[i];
            int idx=0;
            boolean skipAnswer = false;
            for(int j=i; j<i + weakCnt; j++){
                int nextPos = allWeak[j];
                if(nextPos - pos > res[idx]){
                    pos = nextPos;
                    idx++;
                }
                if(idx == res.length){
                    skipAnswer = true;
                    break;
                }
            }
            if(!skipAnswer){
                answer = res.length;
                return;                
            }
        }
    }
    public void permutation(int depth, int cnt, int[] res, int[] dist, boolean[] visited){
        if(answer != -1) return;
        if(depth== cnt){
            check(res);
            return;
        }
        
        for(int i=0; i<dist.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            res[depth] = dist[i];
            permutation(depth+1, cnt, res, dist, visited);
            visited[i] = false;
        }
        
    }
    public void makeAllWeak(int[] weak,int n){
        for(int i=0; i<allWeak.length; i++){
            int pos = weak[i% weakCnt];
            if(i >= weak.length){
                pos += n;
            }
            allWeak[i] = pos;
            System.out.print(pos+" ");
        }
    }
}
