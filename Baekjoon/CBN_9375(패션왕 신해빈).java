import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for(int i=0; i<t; i++){
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                String[] str = br.readLine().split(" ");
                if(map.containsKey(str[1])){
                    map.put(str[1], map.get(str[1])+1);
                }
                else
                    map.put(str[1], 1);
            }

            int answer=1;
            for (String s : map.keySet()) {
                answer *= map.get(s)+1;
            }
            System.out.println(answer -1);
        }
    }
}

//조합 
