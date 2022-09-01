import java.io.*;
import java.util.*;
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        StringBuilder sb = new StringBuilder();
        //왼쪽이 maxheap 오른쪽이 minheap인데
        //새로운 num이 왼쪽에 들어가야하는데 minheap보다 크다면
        //minheap애를 max힙으로 옮기고 num은 minheap에 넣자
        //오른족에 넣어야하는데 이번엔  num이 maxheap보다 작다면
        //maxheap애를 minheap으로 옮기고
        //num을 maxheap에 넣자
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.println(sb);

    }
}
