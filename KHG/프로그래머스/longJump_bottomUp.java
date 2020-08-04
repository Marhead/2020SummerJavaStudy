class Solution {
    public long solution(int n) {
        int[] a = new int[2001];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i <= n; i++)
            a[i] = (a[i-1] + a[i-2]) % 1234567;            
        return a[n];
    }
}