import java.io.*;

class Main{
    static int[][] map = new int[10][10];
    static int[][] copyMap = new int[10][10];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<10; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<10; j++){
                if(str[j].equals("#")){
                    map[i][j] = -1; //꺼진경우
                }
                else{
                    map[i][j] = 1; //켜진경우\
                }
            }
        }

        //첫번째 모든 경우의 수 고려
        for(int i=0; i<=10; i++){
            //조합의 경우
            combination(i, 0,0);
        }


        System.out.println(answer);
    }
    static void combination(int n, int start, int depth){
        if(depth ==n){
            int result = pressSwitch(depth);
            for(int i=0; i<10; i++){
                if(copyMap[9][i] == 1){
                    return;
                }
            }
            answer = Math.min(result, answer);
            return;
        }
        for(int i=start; i<10; i++){
            map[0][i] = -map[0][i];
            for(int j=0; j<4; j++){
                int nextX = 0+dx[j];
                int nextY = i+dy[j];
                if(nextX >=0 && nextX <10 && nextY >=0 && nextY <10){
                    map[nextX][nextY] = -map[nextX][nextY];
                }
            }
            combination(n, i, depth+1);
            for(int j=0; j<4; j++){
                int nextX = 0+dx[j];
                int nextY = i+dy[j];
                if(nextX >=0 && nextX <10 && nextY >=0 && nextY <10){
                    map[nextX][nextY] = -map[nextX][nextY];
                }
            }
            map[0][i] = -map[0][i];
        }
    }
    static int pressSwitch(int result){
        mapClone(map, copyMap);
        for(int i=1; i<10; i++){
            for(int j=0; j<10; j++){
                if(copyMap[i-1][j] != 1) continue;

                //자신 스위치 누르기
                copyMap[i][j] = -copyMap[i][j];
                result++;
                for(int k=0; k<4; k++){
                    int nextX = i+dx[k];
                    int nextY = j+dy[k];

                    if(nextX >=0 && nextX <10 && nextY >=0 && nextY <10){
                        copyMap[nextX][nextY] = -copyMap[nextX][nextY];
                    }
                }
            }
        }
        return result;
    }
    static void mapClone(int[][] map, int[][] copyMap){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                copyMap[i][j] = map[i][j];
            }
        }

    }
}
