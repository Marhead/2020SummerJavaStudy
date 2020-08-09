class Solution {
    int[] numbers = new int[2000];

    public long solution(int n) {
        long answer = 0;

        for(int i = 0 ; i < n; i++) {
            numbers[i] = recursive(n);
        }

        answer = numbers[n] % 1234567;
        return answer;
    }
    public int recursive(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return recursive(n-1) + recursive(n-2);
    }
}