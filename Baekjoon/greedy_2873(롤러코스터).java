import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        int[][] map;

        map = new int[r][c];
        for(int i=0; i<r; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //r이 홀수 인경우
        if(r%2==1){
            for(int i=0; i<r; i++){
                if(i%2==0){
                    addDir(sb1, "R", c-1);
                    if(i==r-1) continue;
                    addDir(sb1, "D", 1);
                }
                else{
                    addDir(sb1, "L", c-1);
                    addDir(sb1, "D", 1);
                }
            }
        }
        //c가 홀수인 경우
        else if(c%2 == 1){
            for(int i=0; i<c; i++){
                if(i%2==0){
                    addDir(sb1, "D", r-1);
                    if(i==c-1) continue;
                    addDir(sb1, "R", 1);}
                else{
                    addDir(sb1, "U",r-1);
                    addDir(sb1, "R", 1);
                    }
            }
        }
        //r c가 짝수인 경우
        else{
            int minR, minC;
            minR = 0;
            minC = 1;
            for (int i=0; i<r; i++) { //검정칸 중 젤 작은 수를 찾는다.
                for (int j=0; j<c; j++) {
                    if ((i+j)%2 == 1) {
                        if (map[minR][minC] > map[i][j]) {
                            minR = i;
                            minC = j;
                        }
                    }
                }
            }

            //위아래로 두줄 단위로 실행함
            //ex) minR이 3이라면 minR/2 = 1  따라서 1번째 칸에 minR이 존재함, 1번째칸의 row 는 3,4가 해당됨
            //따라서 minR과 같은 칸에 해당하기 전까지는 두줄씩 작업가능
            int sr =0, sc=0;
            int er =r-1, ec=c-1;

            //윗부분 먼저채움
            while(er - sr >1){
                if(sr/2 < minR/2){
                    addDir(sb1, "R", c-1);
                    addDir(sb1, "D", 1);
                    addDir(sb1, "L", c-1);
                    addDir(sb1, "D", 1);
                    sr += 2;
                }
                if(er/2 > minR/2){
                    addDir(sb2, "R", c-1);
                    addDir(sb2, "D", 1);
                    addDir(sb2, "L", c-1);
                    addDir(sb2, "D", 1);
                    er -=2;
                }
            }
            while(ec - sc > 1){
                if(ec/2 > minC /2){
                    addDir(sb2,"D",1);
                    addDir(sb2,"R",1);
                    addDir(sb2,"U",1);
                    addDir(sb2,"R",1);
                    ec-=2;
                }
                if(sc/2 < minC /2){
                    addDir(sb1,"D",1);
                    addDir(sb1,"R",1);
                    addDir(sb1,"U",1);
                    addDir(sb1,"R",1);
                    sc+=2;
                }
            }
            if(sc == minC){
                addDir(sb1,"R",1);
                addDir(sb1,"D",1);

            }
            else{
                addDir(sb1,"D",1);
                addDir(sb1,"R",1);
            }

        }
        sb1.append(sb2.reverse());
        System.out.println(sb1);
    }
    static void addDir(StringBuilder sb, String dir, int n){
        for(int i=0; i<n; i++){
            sb.append(dir);
        }
    }
}
