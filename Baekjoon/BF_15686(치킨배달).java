//(1,1)부터 시작
// 거리의 차이는 x좌표 차이 + y좌표 차이
// 0 : 빈칸 , 1: 집 , 2 : 치킨집
// 도시의 치킨거리가 가장 적을때 (모든집에서 가장 가깝게 떨어진곳)

import java.util.*;
import java.io.*;

class Main{
    static int result=987654321;
    static List<int[]> candidate = new ArrayList<>();
    static int[][] cdis;
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        map = new int[N][N];
        cdis = new int[N][N];
        for(int i=0; i<N; i++){
            String[] st = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        
        search(0, 0);
        System.out.println(result);
    }
    static void search(int start, int num){
        if(num==M){
            //치킨거리 뽑고
            chickenDistance();
            //도시의 치킨거리 계산
            int currentCityDis = cityDistance();
            //System.out.println(currentCityDis);
            //최소값이라면result에 값 넣기
            result = Math.min(result, currentCityDis);
            return;
        }
        for(int i=start; i<N*N; i++){
            int x = i/N;
            int y = i%N;
            
            if(map[x][y]==2){
              int[] temp = new int[]{x,y};
              candidate.add(temp);
              search(i+1, num+1);
              candidate.remove(temp);
            }
        }
    }
    static int cityDistance(){
        int result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result += cdis[i][j];
                //System.out.println("cdis "+i+","+j+" : "+result);
            }
        }
        initCdis();
        return result;
    }
    static void chickenDistance(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    for(int[] c : candidate){
                        int temp = Math.abs(i-c[0]) + Math.abs(j-c[1]);
                        if(cdis[i][j]==0){
                            cdis[i][j] = temp;
                        }
                        else
                          cdis[i][j] = Math.min(cdis[i][j], temp);
                    }
                }
            }
        }
    }
    static void initCdis(){
      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
          cdis[i][j]=0;
        }
      }
    }
}
