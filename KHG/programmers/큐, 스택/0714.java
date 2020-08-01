class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        /* 먼저 각각의 process를 완성시키는데 걸리는 날을 배열로 만듦 */

        int proLen = progresses.length;
        int[] days = new int[proLen];

        for(int i = 0; i < proLen; i++) {

            days[i] = (100 - progresses[i]) / speeds[i];

            // 이 때 나머지가 있으면 1을 더해줌
            if( (100 - progresses[i]) % speeds[i] > 0)
                days[i]++;    

        }
        
        /* 그 다음 날짜를 바탕으로 한번 배포 될 때 몇 개의 기술이 배포 되는지를 저장하는 배열을 만듦*/

        int daysLen = days.length;
        int releaseProcessNum = 1;      // 이번에 배포될 때 추가되는 기술의 개수
        int releaseNum = 0;             // 배포된 횟수
        int[] release = new int[100];   // 저장할 배열

        for(int i = 1; i < daysLen; i++){

            // 전 기술보다 빨리 완성되면
            if(days[i] <= days[i-1]) {
                days[i] = days[i-1];   // 같이 배포되므로 값을 lastReleaseDay로 바꿔줌
                releaseProcessNum++;        // 배포되는 기술의 수가 늘어남
            }
            // 전 기술보다 늦게 완성되면
            else {
                release[releaseNum] = releaseProcessNum;    // 이 전 process까지 배포한다.
                releaseProcessNum = 1;                      // 초기화
                releaseNum++;                               // 배포된 횟수를 증가시킨다.
            }
        }

        // 마지막 process까지 배포해준다.
        days[releaseNum] = releaseProcessNum;
        
        /* 배열을 길이에 맞춰 다시 만들고 복사한다 */
        
        int[] answer = new int[releaseNum + 1];

        for(int i = 0; i <= releaseNum + 1; i++)
            answer[i] = release[i];

        return answer;
    }
}