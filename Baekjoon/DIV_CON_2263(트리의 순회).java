import java.io.*;

class Main{
    static int[] inOrder;
    static int[] postOrder;
    static int[] position;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        position = new int[1000001];

        String[] str = br.readLine().split(" ");
        String[] str1 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            inOrder[i] = Integer.parseInt(str[i]);
            postOrder[i] = Integer.parseInt(str1[i]) ;
            //postOrder 의 노드 위치가 inOrder어디에 있는가 체크하기
            position[inOrder[i]] = i;
        }
        solve(0,n-1,0,n-1);

    }
    public static void solve(int in_start, int in_end, int po_start, int po_end){
        if(in_start>in_end || po_start>po_end) return;
        int root = postOrder[po_end];
        System.out.print(root+" ");
        int p = position[root];

        int left = p-in_start;
        //좌 우로 나누기
        solve(in_start, p-1, po_start, po_start+left-1);
        solve(p+1, in_end, po_start+left, po_end-1);
    }
}
