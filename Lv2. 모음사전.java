1. 수학으로 해결

class Solution {
    private static final String VOWELS = "AEIOU";
    private static final int MAX_LENGTH = 5;
    
    public int solution(String word) {
        int rank = 0;
        for(int position = 0; position < word.length(); position++) {
            int skippedLetters = VOWELS.indexOf(word.charAt(position));
            int remainingSlots = MAX_LENGTH - position;
            rank += skippedLetters * countWordsWithinLength(remainingSlots) + 1;
        }
        return rank;
    }
    
    private int countWordsWithinLength(int remainingSlots) {
        int count = 0;
        int wordsOfCurrentLength = 1;
        for(int i = 0; i < remainingSlots; i++) {
            count += wordsOfCurrentLength;
            wordsOfCurrentLength *= 5;
        }
        return count;
    }
}