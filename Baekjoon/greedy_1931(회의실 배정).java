import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class Main{
    static int[] coin;
    static int k;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        Time[] time = new Time[n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            time[i] = new Time(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        //가장빨리 끝나는 시간 넣어주기
        //curtime을 end로 변경
        Arrays.sort(time);
        int answer=0;
        int curTime=0;

        for(int i=0; i<n; i++){
            if(curTime <= time[i].start){
                curTime = time[i].end;
                answer++;
            }
        }

        System.out.println(answer);
    }
    static class Time implements Comparable<Time>{
        int start;
        int end;
        Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end==o.end) return this.start - o.start;
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
