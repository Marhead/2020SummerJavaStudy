class SolutionK {

	/* 알고리즘
	 * 1. commands[n]에 있는 {i,j,k}에서 array[i-1] ~ array[j-1] 까지 잘라서 임시배열 temparray 에 저장
	 * 2. temparray를 정렬
	 * 3. temparray[k-1]의 값을 answer[n]에 대입
	 */
	public int sort(int []array,int k) {
		/*
		 * 알고리즘 2.를 해결하기위한 함수 작성
		 */
		int n = array.length-1;
		int end = n;
		int temp;

		for(int i=0;i<n;i++)//총 n번 반복. n=length-1
		{
			for(int j=0;j<end;j++)//총 end번 반복. end는 for문 끝날때마다 -1씩 해줌.
			{
				/*
				 * array[j]>array[j+1]이면 둘이 교체
				 */
				if(array[j]>array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			end--;
		}


		return array[k-1];
	}
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        int a,b,index=0;//a = commands[i]의 1번째 값, b = commands[i]의 2번째 값, index는 temparray의 index값
        int[] temparray = {}; //임시배열

        for(int i=0;i<commands.length;i++) {
        	/*
        	 * 알고리즘 1.을 해결 하기 위한 for문
        	 */
        	a = commands[i][0]-1;
        	b = commands[i][1]-1;
        	temparray = new int[b-a+1];
        	for(int k=a;k<=b;k++) {
        		temparray[index++] = array[k];
        	}
        	index = 0;

        	/*
        	 * 알고리즘 3.을 해결 하기 위한 함수호출
        	 */
        	answer[i] = sort(temparray,commands[i][2]);

        }

        return answer;
    }
}
public class theNumberOfK {
	public static void main(String []args) {
		SolutionK s = new SolutionK();
		int []array = {1,5,2,6,3,7,4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {3, 7, 2}};
		int []answer = s.solution(array,commands);
		for(int i : answer)
			System.out.print(i+" ");
	}
}
