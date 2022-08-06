import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//깊은 복사를 사용하고 싶다면
//for(int i=0; i<n; i++){
//System.arraycopy(map[i], 0, copyMap[i], 0, copyMap[i].length);
//} 이와 같이 해당 행마다 복사를 해주어야한다.
public class Main {
    static int[][] map;
    static int n;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        //map 초기화
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");

            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int depth){
        if(depth == 5){
            max = Math.max(max, getMaxValue());
            return;
        }
        int[][] copyMap = new int[n][n];
        copyArr(map, copyMap); //2차원 배열의 깊은 복사를 조심하자 !
      
      
        //direction 0 : up, 1: down, 2: left, 3: right
        for(int i=0; i<4; i++){
            move(i);
            dfs(depth+1);
            copyArr(copyMap, map);
            //System.arraycopy(copyMap, 0, map, 0, map.length);
        }
    }
    static void move(int dir){
        Queue<Integer> q = new LinkedList<>();
        if(dir==0){
            for(int c=0; c<n; c++){
                int idx =0;
                for(int r=0; r<n; r++){
                    if(map[r][c] !=0){
                        q.offer(map[r][c]);
                        map[r][c]=0;
                    }
                }

                while(!q.isEmpty()){
                    int num = q.poll();

                    if(map[idx][c]==0){ //비어있을때
                        map[idx][c] = num;
                    }
                    else if(map[idx][c]==num){ //이미 들어있고 같을때
                        map[idx++][c] *= 2;
                    }
                    else{ //이미 들어있고 같지 않을때
                        map[++idx][c] = num;
                    }

                }
            }

        }else if(dir ==1){
            for(int c=0; c<n; c++){
                int idx = n-1;

                for(int r=n-1; r>-1; r--){
                    if(map[r][c] !=0){
                        q.offer(map[r][c]);
                        map[r][c]=0;
                    }
                }

                while(!q.isEmpty()){
                    int num = q.poll();

                    if(map[idx][c]==0){ //비어있을때
                        map[idx][c] = num;
                    }
                    else if(map[idx][c]==num){ //이미 들어있고 같을때
                        map[idx--][c] *= 2;
                    }
                    else{ //이미 들어있고 같지 않을때
                        map[--idx][c] = num;
                    }

                }
            }
        }else if(dir ==2){
            for(int r=0; r<n; r++){
                int idx =0;

                for(int c=0; c<n; c++){
                    if(map[r][c] !=0){
                        q.offer(map[r][c]);
                        map[r][c]=0;
                    }
                }

                while(!q.isEmpty()){
                    int num = q.poll();

                    if(map[r][idx]==0){ //비어있을때
                        map[r][idx] = num;
                    }
                    else if(map[r][idx]==num){ //이미 들어있고 같을때
                        map[r][idx++] *= 2;
                    }
                    else{ //이미 들어있고 같지 않을때
                        map[r][++idx] = num;
                    }

                }
            }
        }else if(dir==3){
            for(int r=0; r<n; r++){
                int idx = n-1;

                for(int c=n-1; c>-1; c--){
                    if(map[r][c] !=0){
                        q.offer(map[r][c]);
                        map[r][c]=0;
                    }
                }

                while(!q.isEmpty()){
                    int num = q.poll();

                    if(map[r][idx]==0){ //비어있을때
                        map[r][idx] = num;
                    }
                    else if(map[r][idx]==num){ //이미 들어있고 같을때
                        map[r][idx--] *= 2;
                    }
                    else{ //이미 들어있고 같지 않을때
                        map[r][--idx] = num;
                    }

                }
            }
        }
    }
    static int getMaxValue(){
        int max=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, map[i][j]);
            }

        }
        return max;
    }
    static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                b[i][j] = a[i][j];
            }
        }
    }
}
