import java.util.*;

class MarathonSolution {
	/* 알고리즘
	 * 1. participant 배열의 이름을 key, 동명이인 수를 value로 hash에 집어넣었다.
	 * 2. completion 배열의 이름을 훑으면서 hash의 key값과 비교해서 있으면 value를 -1 시켰다.
	 *    그러면 결과적으로 완주하지 못한 선수는 value값이 1로 남아 있게됨.
	 * 3. participant 배열의 이름을 hash에 검색하면서 value값이 1이면 완주하지 못한선수로 answer에 대입시켰다.
	 */
    public String solution(String[] participant, String[] completion) {
    	String answer = "";
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String str : participant)
        {
        	if(map.containsKey(str)) {
        		map.put(str, map.get(str)+1);
        	}
        	else {
        		map.put(str, 1);
        	}
        }
        for(String str : participant)
        {
        	System.out.println(str+" "+map.get(str));
        }
        System.out.println("\n");
        
        
        for(String str : completion) {
        	map.put(str, map.get(str)-1);
        }
        
        for(String str : participant)
        {
        	System.out.println(str+" "+map.get(str));
        }
        
        System.out.println("\n");
        
        for(String str : participant) {
        	if(map.get(str)==1) {
        		answer=str;
        		break;}
        	
        	}
        System.out.print(map.keySet());
        
        	
        
        return answer;
    }
}
public class HashMarathon {
	public static void main (String []args) {
		String[] participant = {"leo", "kiki", "eden", "abc","abc"};
		String[] completion = {"leo", "kiki", "eden", "abc"};
		MarathonSolution s = new MarathonSolution();
		String answer = s.solution(participant, completion);
		System.out.println(answer);
	}
	
}
