class Solution {

    public int[][] map;
    public int[] memoization;
    int xcoordinate = 1;
    int ycoordinate = 1;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        int[] memoization = new int[m*n];

        // 가로값 1로 초기화
        for(int i = 0; i < n; i++) {
            map[0][i] = 1;
        }
        // 세로값 1로 초기화
        for(int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        // 웅덩이들 위치 0으로 변환
        for(int i = 0; i < puddles.length; i++)
        {
            map[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }

        do {
            if(map[ycoordinate][xcoordinate] == -1) {
                map[ycoordinate][xcoordinate] = 0;
                continue;
            }
            map[ycoordinate][xcoordinate] = map[ycoordinate - 1][xcoordinate] + map[ycoordinate][xcoordinate - 1];
            ycoordinate++;
            xcoordinate++;
        } while(ycoordinate == m && xcoordinate == n);

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        answer = map[m-1][n-1];
        return answer;
    }
}