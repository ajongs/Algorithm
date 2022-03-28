import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<n; i++){
            int item = Integer.parseInt(str[i]);

            if(list.get(list.size()-1) < item){
                list.add(item);
                continue;
            }
            int left=0;
            int right = list.size()-1;
            while(left <= right){
                int mid = (left + right)/2;

                if(list.get(mid) >= item){
                    right = mid - 1;
                }
                else if(list.get(mid) <item){
                    left = mid + 1;
                }
            }
            if(left>=0 && left < list.size())
                list.set(left, item);
        }

        System.out.println(list.size()-1);

        br.close();
    }
}
