import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return level;

                char[] currentWordArray = currentWord.toCharArray();
                for (int j = 0; j < currentWordArray.length; j++) {
                    char originalChar = currentWordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currentWordArray[j] == c) continue;
                        currentWordArray[j] = c;
                        String newWord = new String(currentWordArray);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    currentWordArray[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList)); // Output: 5
    }
}


//A transformation sequence from word beginWord to word endWord using a dictionary wordList 
//is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest 
//transformation sequence from beginWord to endWord, or 0 if no such sequence exists.