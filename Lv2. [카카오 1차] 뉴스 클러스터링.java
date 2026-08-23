import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String[] divStr1 = divideSize2(str1);
        String[] divStr2 = divideSize2(str2);
        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();
        
        if(divStr1.length == 0 && divStr2.length == 0) {
            return 1 * 65536;
        }
        
        for(String piece : divStr1) {
            count1.put(piece, count1.getOrDefault(piece, 0) + 1);
        }
        
        for(String piece : divStr2) {
            count2.put(piece, count2.getOrDefault(piece, 0) + 1);
        }
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(count1.keySet());
        allKeys.addAll(count2.keySet());
        
        int unionSum = 0, intersectionSum = 0;
        for(String key : allKeys) {
            int a = count1.getOrDefault(key, 0);
            int b = count2.getOrDefault(key, 0);
            unionSum += Math.max(a, b);
            intersectionSum += Math.min(a, b);
        }
        
        double answer = (double)intersectionSum / (double)unionSum;   
        return (int)(answer * 65536);
    }
    
    private String[] divideSize2(String str) {
        List<String> result = new ArrayList<>();
        str = str.toLowerCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            if(('a' <= str.charAt(i) && str.charAt(i) <= 'z') && ('a' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'z')){
                result.add(str.substring(i, i + 2));
            }
        }
        
        return result.toArray(new String[0]);
    }
}