import java.io.*;
class Main {
    static int[][] map;
    static int n;
    static int l;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        l = Integer.parseInt(str[1]);
        map = new int[n][n];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        int result=0;
        for(int i=0; i<n; i++){
            if(search(i,0,1))//세로 탐색
                result++;
            if(search(0, i, 0)) result++;
        }
        System.out.println(result);
    }
    public static boolean search(int r, int c, int dir){ //dir 0 좌우 dir 1 상하
        boolean[] visited = new boolean[n];
        int[] height = new int[n];
        if(dir==0){
            for(int i=0; i<n; i++){
                height[i] = map[i][c];
            }
        }else{
            for(int i=0; i<n; i++){
                height[i] = map[r][i];
            }
        }

        //조사시작
        for(int i=0; i<n-1; i++){
            //스킵하는 경우는 같을 때
            if(height[i] == height[i+1]) continue;
            if(Math.abs(height[i] - height[i+1]) > 1) return false;

            //다음 숫자가 큰 경우
            if(height[i]+1 == height[i+1]){
                for(int j=i; j>i-l; j--){
                    if(j<0 || visited[j] || height[i] != height[j]) return false;
                    visited[j] = true;
                }
            }
            //다음 숫자가 작은 경우
            else if(height[i]-1 == height[i+1]){
                for(int j=i+1; j<=i+l; j++){
                    if(j>n-1 || visited[j] || height[i+1] != height[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
