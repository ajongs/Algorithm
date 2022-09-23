class Solution {
    boolean[][] Bar;
    boolean[][] Piller;
    
    boolean checkPiller(int x, int y){
        if(y==0 || Piller[y-1][x]) return true;
        if((x>0 && Bar[y][x-1]) || Bar[y][x] ) return true;
        
        return false;
    }
    boolean checkBar(int x, int y){
        if(Piller[y-1][x] || Piller[y-1][x+1]) return true;
        if(x>0 && Bar[y][x-1] && Bar[y][x+1]) return true;
        
        return false;
    }
    boolean canDelete(int x, int y){
        //x가 영보다 작은 경우도 생각해주기
        for(int i=Math.max(0, x-1); i<=x+1; i++){
            for(int j=y; j<=y+1; j++){
                if(Bar[j][i] && !checkBar(i,j)) return false;
                if(Piller[j][i] && !checkPiller(i,j)) return false;
            }
        }
        return true;
    }
    public int[][] solution(int n, int[][] build_frame) {
        Bar = new boolean[n+2][n+2];
        Piller = new boolean[n+2][n+2];
        
        int count=0;
        for(int[] build : build_frame){
            int x = build[0] , y = build[1];
            int type = build[2], cmd = build[3];
            
            if(type ==0){ //기둥
                if(cmd == 1){ //건설 명령 
                    if(checkPiller(x, y)){
                        Piller[y][x] = true;
                        count++;
                    }
                }else{ //삭제 명령
                    Piller[y][x] = false;
                    if(!canDelete(x, y)){
                        Piller[y][x] = true;
                    }else{
                        count--;
                    }
                }
            }else{ //보
                if(cmd==1){ //건설 명령
                    if(checkBar(x, y)){
                        Bar[y][x] = true;
                        count++;
                    }
                }else{ // 삭제 명령
                   Bar[y][x] = false;
                    if(!canDelete(x, y)){
                        Bar[y][x] = true;
                    }else
                        count--;
                }
            }
        }
        
        int[][] answer = new int[count][3];
        int idx=0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(Piller[j][i]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 0;
                    idx++;
                }
                if(Bar[j][i]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                    idx++;
                }
                
            }
        }
        
        return answer;
    }
}
