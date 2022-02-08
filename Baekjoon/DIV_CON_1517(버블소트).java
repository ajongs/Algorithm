import java.io.*;

class Main{
    static int[] A;
    static int[] B;
    static long count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        A = new int[n];
        B = new int[n];
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        mergeSort(0, n-1);
        System.out.println(count);
    }
    public static void mergeSort(int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }
    public static void merge(int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = low; //이 값이 low냐 0이냐에 따라서 맨마지막 B의 값 복사할때 코드가 달라짐
        while(i<=mid && j<=high){
            if(A[i]<A[j]){
                B[k++] = A[i++];
            }
            else{
                count += mid-i+1;
                B[k++] = A[j++];
            }
        }
        while(i<=mid){
            B[k++] = A[i++];
        }
        while(j<=high){
            B[k++] = A[j++];
        }

        for(int l=low; l<high; l++){
            A[l] = B[l];  //만약 k=0으로 시작했다면 A[l] = B[l-start]; 가 되어야한다. B는 0부터 채웠기때문
        }
    }
}

/*
import java.io.*;

class Main {
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        A = new int[n];
        B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
        System.out.println(merge(0, n-1));
    }

    public static long merge(int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        long ans = merge(start, mid) + merge(mid + 1, end);
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid || j <= end) {
            if (i <= mid && (j > end || A[i] <= A[j])) {
                B[k++] = A[i++];
            } else {
                ans += mid - i + 1;
                B[k++] = A[j++];
            }
        }
        for (int l = start; l <= end; l++) {
            A[l] = B[l - start];
        }
        return ans;
    }
}
*/
