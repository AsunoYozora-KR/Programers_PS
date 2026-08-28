class Solution {
    public String solution(int n, int t, int m, int p) {
        //인덱스와 순서를 일치시키기
        p -= 1;
        
        StringBuilder cheat = new StringBuilder();
        StringBuilder find = new StringBuilder();
        
        int makingNum = t * m;
        for(int i = 0; i < makingNum; i++) {
            inverter(i,n,cheat);
        }
        
        for(int i = 0; i < cheat.length(); i++) {
            if(t <= 0) {
                break;
            }
            
            if(i % m == p) {
                find.append(cheat.charAt(i));
                t--;
            }
        }
        
        return find.toString();
    }
    
    private void inverter(int i, int n, StringBuilder cheat) {
        if(i < n) {
            if(i > 9) {
                cheat.append((char)(i + 55));
            }
            else {
                cheat.append(i);
            }
            return;
        }
        
        inverter(i / n, n, cheat);
        
        if(i % n > 9) {
            cheat.append((char)(i % n + 55));
        }
        else {
            cheat.append(i % n);
        }
    }
}