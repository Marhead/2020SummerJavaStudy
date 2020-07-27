import java.util.*;
class SolutionH {
    public int solution(int[] citations) {
        int answer = 0;
        int n=1;
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--) {
        	if(citations[i]<n)
        		break;
        	n++;
        }
        answer=n-1;
        return answer;
    }
}
public class Hindex {
	public static void main(String []args) {
		SolutionH s = new SolutionH();
		int []citations = {5,5,5};
		int answer = s.solution(citations);
		System.out.println(answer);
	}
}
