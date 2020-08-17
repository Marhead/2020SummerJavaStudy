class Solution {
    static int[] numbers = new int[2000];

    public long solution(int n) {
        long answer = 0;

        recursive(n);

        answer = numbers[n] % 1234567;
        return answer;
    }
    public int recursive(int n) {
        if(n == 0) {
            return numbers[n] = 0;
        }
        if(n == 1) {
            return numbers[n] = 1;
        }
        if(n == 2) {
            return numbers[n] = 2;
        }
        if(numbers[n] != 0) {
            return numbers[n];
        }
        return numbers[n] = (recursive(n-1) + recursive(n-2)) % 1234567;
    }
}