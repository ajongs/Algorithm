import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        ArrayList<Data> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Data data = new Data();
            data.genre = entry.getKey();
            data.play = entry.getValue();
            list.add(data);
        }
        Collections.sort(list, Collections.reverseOrder());

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            ArrayList<Songs> songs = new ArrayList<>();

            for(int j=0; j<plays.length; j++){
                if(list.get(i).genre.equals(genres[j])){
                    //System.out.println("list.get(i).genre = " + list.get(i).genre);
                    //System.out.println("genres = " + genres[i]);
                    songs.add(new Songs(plays[j], j));
                }
            }
            Collections.sort(songs, Collections.reverseOrder());
            if(songs.size() >= 2){
                result.add(songs.get(0).index);
                result.add(songs.get(1).index);
            }
            else{
                result.add(songs.get(0).index);

            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).intValue();
        }
        return answer;
    }
}
class Songs implements Comparable<Songs>{
    int plays;
    int index;
    Songs(int plays, int index){
        this.plays = plays;
        this.index = index;
    }
    @Override
    public int compareTo(Songs s){
        return this.plays - s.plays;
    }
}
class Data implements Comparable<Data>{
    String genre;
    int play;
    
    @Override
    public int compareTo(Data d){
        return this.play - d.play;
    }
        
}
