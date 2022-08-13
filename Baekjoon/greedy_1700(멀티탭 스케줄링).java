import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        boolean[] used = new boolean[k+1]; //얘는 인덱스 7까지 존재

        str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(Integer.parseInt(str[i])); //얘는 인덱스 6까지 존재
        }

        int result =0;
        int usedPortNum =0;
        for(int i=0; i<k; i++){
            int cur = list.get(i);

            //이미 꽂아져 있는 콘센트라면 스킵
            if(used[cur]) continue;
            //남은 콘센트가 있다 그러면 ㄲ
            if(usedPortNum < n){
                usedPortNum++;
                used[cur] = true;
            }
            //남은 콘센트가 없다
            else{
                //남아 있는 것들 중 나중에 또 사용되는지 체크
                ArrayList<Integer> reuseList = new ArrayList<>();
                for(int j=i+1; j<k; j++){ //list 순서대로 입력했으므로
                    int num = list.get(j);
                    if(used[num] && !reuseList.contains(num))
                        reuseList.add(num); //가장 마지막 원소가 가장 늦게 사용되는 것
                }
                int popIndex=0;
                //다 다시 사용되는 경우
                if(reuseList.size() == n){
                    //가장 마지막 원소를 삭제
                    popIndex = reuseList.get(reuseList.size()-1);
                }
                //하나 이상 다시 사용되지 않는 경우
                else{
                    //사용되지 않는 인덱스를 찾음
                    //used[ㅓ]을 돌면서 해당
                    for(int j=1; j<k+1; j++){
                        if(used[j] && !reuseList.contains(j)){
                            popIndex = j;
                            break;
                        }
                    }
                }
                used[popIndex] = false;
                result++;
                used[cur] = true;

            }

        }
        System.out.println(result);
    }
}
