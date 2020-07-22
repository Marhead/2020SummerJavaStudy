import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandLength = commands.length;
        int segmentLength;
        int[] answer = new int[commandLength];

        for (int i = 0; i < commandLength; i++) {
            int[] segment = new int [commands[i][1] - commands[i][0] + 1];
            int startIndex = commands[i][0] - 1;
            segmentLength = segment.length;
            for(int j = 0; j < segmentLength; j++){
                segment[j] = array[startIndex++];
            }
            Arrays.sort(segment);
            answer[i] = segment[commands[i][2] - 1];
        }
        
        return answer;
    }
}