class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] daycontainer = new int[progresses.length];
        int iterator;
        int day = 0;    int status = 0;

        //  각 progresses들의 작업완료 일 구해서 daycontainer에 대입
        for (iterator = 0; status == daycontainer.length; iterator++)
        {
            int order = iterator % progresses.length;

            if(order == 0) { day++; }

            progresses[order] += speeds[order];

            if(progresses[order] >= 100)
            {
                daycontainer[order] = day;
                status++;
            }
        }

        int count = 1;
        int answeriterator = 0;
        int[] tempcontainer = new int[daycontainer.length];

        for (int i = 1; i < tempcontainer.length; i++)
        {
            if(daycontainer[i-1] < daycontainer[i])
            {
                tempcontainer[answeriterator] = count;
                answeriterator++;
            }
            else 
            {
                count++;
                daycontainer[i] = daycontainer[i-1];
            }
        }

        // // temp값들 중 첫째 값 부터 뒤에 값 비교, 삭제
        // int count = 1;
        // int answerpoint = 0;
        // int[] tempanswer = new int[temp.length];
        // Arrays.fill(tempanswer, 0);

        // for (int i = 0 ; i < temp.length - 1; i++)
        // {
        //     if(temp[i] >= temp[i+1])
        //     {
        //         count++;
        //         temp[i+1] = temp[i];
        //     } else {
        //         tempanswer[answerpoint] = count;
        //         answerpoint++;
        //     }
        // }

        int[] answer = new int[answeriterator];
        for (int i = 0; i < answeriterator; i++)
        {
            answer[i] = tempcontainer[i];
        }
        return answer;
    }
}