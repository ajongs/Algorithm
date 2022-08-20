import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    static int[] dx = {-1, 1, 0};
    static boolean[] arr;
    static boolean[] destArr;
    static boolean[] copyArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] books = new int[n];
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            books[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(books);
        //부호로 나누기
        for(int i=0; i<n; i++){
            if(books[i] < 0){
                minus.add(Math.abs(books[i]));
            }
            if(books[i] > 0){
                plus.add(books[i]);
            }
        }
        Collections.reverse(plus);
        //누가 더 큰지 비교
        int result =0;

        if(minus.size()>0 && plus.size()>0){
            if(minus.get(0) < plus.get(0)){
                //플러스가 더큰 경우
                //플러스를 젤 마지막에 플러스
                int lastIdx =0;
                result += minus.get(0)*2;
                for(int i=1; i< minus.size()/m; i++){
                    result += minus.get(i*m)*2;
                    lastIdx = i*m;
                }
                if(minus.size()%m !=0 && minus.size()/m >0){
                    result += minus.get(lastIdx+m)*2;

                }
                result += plus.get(0);
                for(int i=1; i< plus.size()/m; i++){
                    result += plus.get(i*m)*2;

                    lastIdx = i*m;
                }
                if(plus.size()%m !=0 && plus.size()/m >0) {
                    result += plus.get(lastIdx+m)*2;

                }
            }
            else{
                //minus 절댓값 가장 큰걸 마지막에 접근 ==> 돌아올필요 x
                int lastIdx =0;
                result+= minus.get(0);
                for(int i=1; i< minus.size()/m; i++){
                    result += minus.get(i*m)*2;
                    lastIdx = i*m;
                }
                if(minus.size()%m !=0 && minus.size()/m >0){
                    result += minus.get(lastIdx+m)*2;
                }
                result += plus.get(0)*2;
                for(int i=1; i< plus.size()/m; i++){
                    result += plus.get(i*m)*2;
                    lastIdx = i*m;
                }
                if(plus.size()%m !=0 && plus.size()/m >0){
                    result += plus.get(lastIdx+m)*2;
                }
            }
        }
        else if(minus.size()==0){
            int lastIdx=0;
            result += plus.get(0);
            for(int i=1; i< plus.size()/m; i++){
                result += plus.get(i*m)*2;
                lastIdx = i*m;
            }
            if(plus.size()%m !=0 && plus.size()/m > 0){
                result += plus.get(lastIdx+m)*2;
            }
        }
        else{
            int lastIdx =0;
            result+= minus.get(0);
            for(int i=1; i< minus.size()/m; i++){
                result += minus.get(i*m)*2;
                lastIdx = i*m;
            }
            if(minus.size()%m !=0 && minus.size()/m >0){
                result += minus.get(lastIdx+m)*2;
            }
        }

        System.out.println(result);
    }
}
