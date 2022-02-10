import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main{
    static Building[] b;
    static List<int[]> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        b = new Building[n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int h = Integer.parseInt(str[1]);
            int r = Integer.parseInt(str[2]);
            b[i] = new Building(l, h ,r);
            }
            Arrays.sort(b, new Comparator<Building>() {
                @Override
                public int compare(Building o1, Building o2) {
                    return o1.L-o2.L;
                }
            });
        ans = go(0, n-1);

        for (int[] p : ans) {
            bw.write(p[0] +" "+p[1]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static List<int[]> merge(List<int[]> l, List<int[]> r){
        //여기서 확인 할거
        //현재 x좌표 상 빌딩 높이 알아야함
        int h1=0;
        int h2=0;
        int i=0;
        int j=0;
        List<int[]> sorted = new ArrayList<>();
        while(i<l.size() && j<r.size()){
            int[] u = l.get(i);
            int[] v = r.get(j);
            if(u[0] < v[0]){
                int x = u[0];
                h1 = u[1];
                int h = Math.max(h1, h2);
                append(sorted, x, h);
                i++;
            }
            else{
                int x = v[0];
                h2 = v[1];
                int h = Math.max(h1, h2);
                append(sorted, x, h);
                j++;
            }
        }
        //한쪽만 다 채워지면 다른 쪽 채우기
        while(i < l.size()){
            sorted.add(l.get(i++));
        }
        while(j < r.size()){
            sorted.add(r.get(j++));
        }
        return sorted;
    }

    private static void append(List<int[]> ans, int x, int h) {
        int n = ans.size();
        if(n>0){
            if(ans.get(n-1)[1] == h){
                return;
            }
            if(ans.get(n-1)[0] == x){
                ans.get(n-1)[1] = h;
                return;
            }
        }
        ans.add(new int[]{x, h});
    }

    public static List<int[]> go(int start, int end){
        if(start == end){
            List<int[]> ans = new ArrayList<>();
            ans.add(new int[]{b[start].L, b[start].H});
            ans.add(new int[]{b[start].R, 0});

            return ans;
        }
        int mid = (start + end)/2;
        List<int[]> l = go(start, mid);
        List<int[]> r = go(mid+1, end);
        return merge(l, r);
    }
    public static class Building{
        public int L;
        public int H;
        public int R;

        Building(int L, int H, int R){
            this.L = L;
            this.H = H;
            this.R = R;
        }
    }
}
