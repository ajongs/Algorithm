import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        List<Integer> chainList = new LinkedList<>();
        for(int i=0; i<n; i++){
            chainList.add(Integer.parseInt(str[i])); //체인 리스트 초기화
        }

        //체인 리스트 오름차순 정렬
        Collections.sort(chainList);


        int count=0;
        //체인 리스트 사이즈가 1일때 까지 반복
        while(chainList.size()>1){
            chainList.set(0, chainList.get(0)-1);
            chainList.remove(chainList.size()-1);
            if(chainList.get(0) ==0){
                chainList.remove(0);
            }
            count++;
        }
        System.out.println(count);
    }
}
