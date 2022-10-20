import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1450 {
    static ArrayList<Integer> left;
    static ArrayList<Integer> right;
    static int[] arr;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        arr = new int[n];
        str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        dfs(0,n/2,0,left);
        dfs(n/2, n, 0, right);
        Collections.sort(right);
        Collections.sort(left);

        /*
        for (Integer integer : left) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer integer : right) {
            System.out.print(integer+" ");
        }*/



        int end = right.size()-1;
        int cnt=0;
        
        for(int i=0; i<left.size(); i++){
            int l = left.get(i);
            while(end >=0 && l + right.get(end) > c){
                end--;
            }
            cnt += end+1;
            //end를 초기화 하지 않는 이유는 left 값이 커지는 순으로 정렬 되어 있으므로 
            //이전의  left(i)+end은 left(i-1)+ end보다 항상 큰 값이므로 end이상의 값을 비교할 필요가 없음
            //어차피 c값을 넘을테니까 
        }
        System.out.println(cnt);

    }
    public static void dfs(int start, int end, int sum, ArrayList<Integer> list){
        if(sum > c) return;
        if(start == end){
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum, list);
        dfs(start+1, end, sum+arr[start], list);
    }
}
