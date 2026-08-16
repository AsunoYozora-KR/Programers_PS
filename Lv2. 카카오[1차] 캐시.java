import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> list = new ArrayList<>();
        int time = 0;
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for(String city1 : cities) {
            String city = city1.toLowerCase();
            int idx = list.indexOf(city);
            
            if(idx != -1) {
                list.remove(idx);
                list.add(city);
                time++;
            }
            else {
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
                time += 5;
            }
        }
        return time;
    }
}

//LRU(Least Recently Used) 알고리즘이란?
//캐시에 같은 같은 값이 있다면 해당 값을 가장 앞으로 옮긴다, 그리고 추가하지 않는다
//캐시에 같은 값이 없다면 캐시에 해당 값을 추가하는데,
//만약 캐시가 가득 찼다면 가장 오래된 값을 삭제하고 해당 값을 추가한다.