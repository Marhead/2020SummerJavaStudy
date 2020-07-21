import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int startpoint, endpoint, target;
        int[] temp;
        int[] tempanswer = new int[commands.length];

        for(int i = 0; i < commands.length; i++)
        {
            startpoint = commands[i][0] - 1;
            endpoint = commands[i][1];
            target = commands[i][2] - 1;

            temp = Arrays.copyOfRange(array, startpoint, endpoint);

            Arrays.sort(temp);

            tempanswer[i] = temp[target];
        }
        int[] answer = Arrays.copyOf(tempanswer, tempanswer.length);

        return answer;
    }
}