class Solution {
    static int[] a = new int[2001];
    public long solution(int n) {
        int answer = Hello(n);
        return answer;
    }
    public static int Hello(int num) {
        if(num == 0) return 1;
        if(num == 1) return 1;
        if(a[num] != 0) return a[num]; 
        return a[num] = (Hello(num-1) + Hello(num-2)) % 1234567;
    }
}