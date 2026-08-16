import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Tuple> tuple = new ArrayList<>();
        
        //괄호 제거
        String s1 = s.replace("{", "");
        String s2 = s1.replace("}", "");
        s = s2;
        //분할 후 리스트에 저장
        String[] splits = s.split(",");
        Arrays.sort(splits);
        
        for(int i = 0, idx = 0; i < splits.length; i++) {
            //중복되지 않을 때
            if(tuple.size() == 0 || !(tuple.get(idx - 1).name.equals(splits[i]))) {
                Tuple box = new Tuple();
                box.name = splits[i];
                box.num++;
                tuple.add(box);
                idx++;
            }
            //중복될 때
            else {
                Tuple change = tuple.get(idx - 1);
                change.num++;
            }
        }
        //람다식을 사용한 정렬
        tuple.sort(Comparator.comparingInt((Tuple t) -> t.num).reversed());
        int[] answer = new int[tuple.size()];
        for(int i = 0; i < tuple.size(); i++) {
            answer[i] = Integer.parseInt(tuple.get(i).name);
        }
        return answer;
    }
}

class Tuple {
    String name;
    int num = 0;
}