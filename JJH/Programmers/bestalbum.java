import java.util.*;

class Gen{
	int count=0;
	Map<Integer,Integer> H2 = new HashMap<Integer,Integer>();
	
	List<Integer> keysetList = new ArrayList<Integer>();
	
	public List<Integer> sortBycount2(final Map<Integer,Integer> map)
    {
    	List<Integer>list = new ArrayList<Integer>();
    	list.addAll(map.keySet());
    	
    	Collections.sort(list, new Comparator() {
    		public int compare(Object o1,Object o2) {
    			Object v1 = map.get(o1);
    			Object v2 = map.get(o2);
    			if(((Comparable)v2).compareTo(v1)==0)
    				return ((Comparable)o1).compareTo(o2);
    			else
    				return ((Comparable)v2).compareTo(v1);
    		}
    	});
    	return list;
    }
}
class Solutionbestalbum{ 
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerlist = new ArrayList<Integer>();
        HashMap<String,Gen>H1 = new HashMap<String,Gen>();
        for(int i=0;i<genres.length;i++)
        {
        	if(H1.containsKey(genres[i])) {// 장르값이 기존에 존재하면
        		H1.get(genres[i]).count+=plays[i];//count += plays[i]
        		H1.get(genres[i]).H2.put(i, plays[i]);//H2에 넣음.
        	}
        	
        	else {// 장르값이 기존에 존재하지 않으면
        		Gen G = new Gen();
        		G.count=plays[i];//새로운 Gen객체를 만들어서
        		H1.put(genres[i], G);//H1 map에 넣어준다.
        		H1.get(genres[i]).H2.put(i, plays[i]);
        	}
        }
       
        ////////data 넣기 끝
        
        
        
        
        
        
        
        
        Iterator it = sortBycount(H1).iterator();
        while(it.hasNext()) {
        	int count=0;
            String temp = (String) it.next();
            //System.out.println(temp+" "+H1.get(temp).count);
            H1.get(temp).keysetList = H1.get(temp).sortBycount2(H1.get(temp).H2);
            
            Iterator it2 = H1.get(temp).keysetList.iterator();
            while(it2.hasNext()) {
            	Integer c = (Integer) it2.next();
            	//System.out.println(c+" "+H1.get(temp).H2.get(c));
            	answerlist.add(c);
            	count++;
            	if(count>=2)
            		break;
            }
        }
        Iterator it4answer = answerlist.iterator();
        answer = new int[answerlist.size()];
        int answerindex=0;
        while(it4answer.hasNext())
        	{
        	//System.out.print((Integer)it4answer.next()+" ");
        		answer[answerindex++]=(Integer)it4answer.next();
        	}
        
        return answer;
    }
    
    
    public List<String> sortBycount(final Map<String,Gen> map)
    {
    	List<String>list = new ArrayList<String>();
    	list.addAll(map.keySet());
    	
    	Collections.sort(list, new Comparator() {
    		public int compare(Object o1,Object o2) {
    			Object v1 = map.get(o1).count;
    			Object v2 = map.get(o2).count;
    			return ((Comparable)v2).compareTo(v1);
    		}
    	});
    	return list;
    }
    
}
public class BestAlbum {
	public static void main(String[] args)
	{
		String []genres = {"classic","pop","classic","classic","pop","hiphop","pop","hiphop","rap"};
		int []players = {400, 600, 500, 600, 2500, 1200, 900, 740, 120};
		Solutionbestalbum s = new Solutionbestalbum();
		int []answer = s.solution(genres, players);
		for(int i:answer)
			System.out.print(i+" ");
		
	}
}
