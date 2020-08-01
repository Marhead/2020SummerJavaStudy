import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length];

        ArrayList<Integer> genrevaluesort = new ArrayList<>();
        ArrayList<String> genresort = new ArrayList<>();
        HashMap<String, Integer> albumlist = new HashMap<>();
        HashMap<Integer, Integer> valueorder = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(albumlist.containsKey(genres[i])) {
                albumlist.put(genres[i], albumlist.get(genres[i]) + plays[i]);
            } else {
                albumlist.put(genres[i], plays[i]);
            }
        }
        // 장르 + 플레이총합 해쉬 맵 생성

        for(int i = 0; i < genres.length; i++) {
            valueorder.put(i, plays[i]);
        }
        // 총 크기 순서별 해쉬 맵 생성

        Iterator it = sortByValue(albumlist).iterator();

        while(it.hasNext()) {
            String temp = (String) it.next();
            genresort.add(temp);
        }
        // 장르 순서 정렬

        Iterator newit = sortByValue(valueorder).iterator();

        while(newit.hasNext()) {
            Integer temp = (Integer) newit.next();
            genrevaluesort.add(temp);
        }
        // 전체 크기 정렬

        int i = 0;

        for(int temp : genrevaluesort) {
            answer[i++] = temp;
        }

        return answer;
    }
    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2). compareTo(v1);
            }
        });
        Collections.reverse(list);
        return list;
    }
}