import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        //값을 넣을 때 자동 정렬 + 중복 허용 가능한 자료구조
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < operations.length; i++) {
            if(!map.isEmpty() && operations[i].equals("D 1")) {
                Map.Entry<Integer, Integer> check = map.lastEntry();
                if(check.getValue() == 1) {
                    map.pollLastEntry();
                }
                else {
                    map.put(check.getKey(), check.getValue() - 1);
                }
            }
            else if(!map.isEmpty() && operations[i].equals("D -1")) {
                Map.Entry<Integer, Integer> check = map.firstEntry();
                if(check.getValue() == 1) {
                    map.pollFirstEntry();
                }
                else {
                    map.put(check.getKey(), check.getValue() - 1);
                }
            }
            else if(!operations[i].equals("D 1") && !operations[i].equals("D -1")) {
                int newNum = Integer.parseInt(operations[i].substring(2));
                if(map.containsKey(newNum)) {
                    map.put(newNum, map.get(newNum) + 1);
                }
                else {
                    map.put(newNum, 1);
                }
            }
        }
        
        if(map.isEmpty()){
            return new int[]{0,0};
        }
        
        Map.Entry<Integer, Integer> max = map.lastEntry();
        Map.Entry<Integer, Integer> min = map.firstEntry();
        
        return new int[]{max.getKey(), min.getKey()};
    }
}

//트리맵 자료구조의 특징
//트리맵은 값을 넣을 때, 내부가 이진 탐색 트리로 구성이 되어있어서, 자동으로 정렬이 됨.
//따라서 정렬된 데이터의 최대, 최솟값을 꺼내기 유리