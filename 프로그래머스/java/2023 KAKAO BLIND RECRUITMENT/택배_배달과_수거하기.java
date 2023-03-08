import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<HouseInfo> deliverStack = new Stack<>();
        Stack<HouseInfo> pickStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            deliverStack.push(new HouseInfo(i + 1, deliveries[i]));
            pickStack.push(new HouseInfo(i + 1, pickups[i]));
        }

        initTop(deliverStack);
        initTop(pickStack);

        while (!(deliverStack.isEmpty() && pickStack.isEmpty())) {
            int deliverDist = deliverStack.isEmpty() ? -1 : deliverStack.peek().num;
            int pickDist = pickStack.isEmpty() ? -1 :pickStack.peek().num;
            int dist = Math.max(deliverDist, pickDist);
            //두 스택의 top 비교하기
            answer += dist * 2;
            stackCountDown(deliverStack, cap);
            stackCountDown(pickStack, cap);
        }
        return answer;
    }
    public void initTop(Stack<HouseInfo> stack) {
        if (stack.isEmpty()) return;
        while (!stack.isEmpty() && stack.peek().boxCnt == 0) {
            stack.pop();
        }
    }
    public void stackCountDown(Stack<HouseInfo> stack, int cap) {
        if (stack.isEmpty()) return;
        while (!stack.isEmpty() && cap >= stack.peek().boxCnt) {
            cap -= stack.pop().boxCnt;
        }
        if (!stack.isEmpty() && cap > 0) {
            HouseInfo houseInfo = stack.pop();
            houseInfo.boxCnt -= cap;
            stack.push(houseInfo);
        }
    }
}
class HouseInfo {
    int num;
    int boxCnt;

    public HouseInfo(int num, int boxCnt) {
        this.num = num;
        this.boxCnt = boxCnt;
    }
}
