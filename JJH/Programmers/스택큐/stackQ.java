class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] t = new int[progresses.length];
        int k=1,count=1,temp,index=0;
        for(int i=0 ;i<progresses.length;i++)
        {
        	while(true)
        	{
        		if(progresses[i]+k*speeds[i]>=100)
        		{
        			t[i] = k;
        			break;
        		}
        		k++;
        	}
        	k=1;
        }
        temp=t[0];
        for(int i=0;i<t.length;i++)
        {
        	if(t[i]>temp)
        	{
        		count++;
        		temp=t[i];
        	}
        }
        answer = new int[count];
        count =1;
        temp=t[0];
        for(int i=1;i<t.length;i++)
        {
        	       	
        	if(temp<t[i])
        	{
        		temp=t[i];
        		answer[index++]=count;
        		count=1;
        	}
        	else
        		count++;
        }
        answer[index]=count;
        return answer;
    }
}
public class stackQ {
	public static void main(String[] args)
	{
		int []progresses = {93,30,55};
		int []speeds = {1,30,5};
		
		Solution s = new Solution();
		int []answer=s.solution(progresses, speeds);
		for(int i=0;i<answer.length;i++)
			System.out.println(answer[i]);
	}
}
