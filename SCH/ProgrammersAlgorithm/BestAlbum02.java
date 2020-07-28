import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<Integer> genresort = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            for(int j = i + 1; j < genres.length; j++) {
                if(genres[i] == genres[j]) {

                    plays[i] += plays[j];
                    plays[j] = 0;

                }
            }
        }

        
        return answer;
    }
}