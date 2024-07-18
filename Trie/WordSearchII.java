import java.util.*;

class WordSearchII {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
            word = null;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, visited, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        TrieNode nextNode = node.children[c - 'a'];
        if (nextNode == null) {
            return;
        }

        if (nextNode.isEndOfWord) {
            result.add(nextNode.word);
            nextNode.isEndOfWord = false; // To avoid duplicates
        }

        visited[i][j] = true;

        dfs(board, i + 1, j, nextNode, visited, result);
        dfs(board, i - 1, j, nextNode, visited, result);
        dfs(board, i, j + 1, nextNode, visited, result);
        dfs(board, i, j - 1, nextNode, visited, result);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(sol.findWords(board, words)); // Output: ["oath", "eat"]
    }
}


//Given an m x n board of characters and a list of strings words, return all words on the board.

//Each word must be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.