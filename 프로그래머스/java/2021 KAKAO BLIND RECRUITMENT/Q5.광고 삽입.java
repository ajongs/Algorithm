class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = strToTime(play_time);
        int[] sum = new int[playTime];
        //1. 겹치는 구간 찾는 알고리즘
        for(String log : logs){
            String[] str = log.split("-");
            int startTime = strToTime(str[0]);
            int endTime = strToTime(str[1]);

            for(int i=startTime; i<endTime; i++){
                sum[i]++;
            }
        }
        //2. 광고 시작 시간 찾는 알고리즘
        //누적합 찾는알고리즘
        long count=0;
        int advTime = strToTime(adv_time);
        //누적합 초기값 세팅
        for(int i=0; i<advTime; i++){
            count += sum[i];
        }

        long max = count;
        int maxTime = 0;
        for(int i=advTime; i<playTime; i++){
            count -= sum[i-advTime];
            count += sum[i];

            if(max < count){
                max = count;
                maxTime = i-advTime+1;
            }
        }

        return timeToStr(maxTime);
        // -> 누적 시청자들과 얼마나 겹치는지가 관건
    }
    public int strToTime(String str){
        String[] temp = str.split(":");
        int hour = Integer.parseInt(temp[0]) * 3600;
        int min = Integer.parseInt(temp[1]) * 60;
        int sec = Integer.parseInt(temp[2]);

        return hour+min+sec;
    }
    public String timeToStr(int time){
        String hour = String.format("%02d",time/3600);
        String min = String.format("%02d", (time%3600) / 60);
        String sec = String.format("%02d", time%3600% 60);

        return hour+":"+min+":"+sec;
    }
}
