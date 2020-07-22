import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h = 0;

        Arrays.sort(citations);

        for(int i = 1; i < citations.length; i++)
        {
            if(citations[citations.length - i] == citations.length - citations[citations.length - i] + 1)
            {
                answer = citations[citations.length - i];
            }
        }

        return answer;
    }
}