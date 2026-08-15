//풀이 1. 해쉬 사용 X, 빅오: O(n log(n))

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                return false;               
            }
        }
        return true;
    }
}

//풀이 2. 해쉬 사용 O, 빅오: O(n)

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for(String number : phone_book) {
            for(int i = 1; i < number.length(); i++) {
                if(set.contains(number.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}