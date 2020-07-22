import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int citationLength = citations.length;
        
        int h = 0;
        
        for(int i = 0; i < citationLength; i++){
            if(citations[i] <= citationLength - i) {
                h = citations[i];
            }
            else {
                if(citationLength - i > h) {
                    h = citationLength - i;
                    break;
                }
            }
        }
        return h;
    }
}