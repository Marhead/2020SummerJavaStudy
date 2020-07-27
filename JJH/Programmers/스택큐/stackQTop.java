import java.util.*;
class StackQTopSolution{
	/* 알고리즘
	 * 1. heights를 for문으로 다 돌림
	 * 2. heights[i]일때 heights[i-1] ~ heights[0] 까지 heights[i]보다 큰수가 있는지 판별하고 index+1 을 바로 answer에 넣음.
	 * 3. 없으면 -> 0
	 * 
	 */
	
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0]=0;
        for(int i=1;i<heights.length;i++)
        	for(int k=i-1;0<=k;k--)
        	{
        		if(heights[i]<heights[k])
        		{
        			answer[i]=k+1;
        			break;
        		}
        		answer[i]=0;
        	}
        	
        
        
        
        
        return answer;
	}
}

public class StackQTop {
	public static void main(String []args) {
		int []heights = {1,5,3,6,7,6,5};
		StackQTopSolution solution = new StackQTopSolution();
		int []answer = solution.solution(heights);
		for(int i=0;i<answer.length;i++)
		{
			System.out.print(answer[i]+" ");
		}
	}
}

