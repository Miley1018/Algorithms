package com.company;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mileygao on 8/16/18.
 */
public class ZTrieBoggleGame {
    private static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<String> boggleGame(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return list;
        }
        for (String word : words) {
            if (exist(word, board)) {
                list.add(word);
            }
        }
        return list;
    }
    private boolean exist(String word, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (dfsHelper(word, board,0,  i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfsHelper(String word, char[][] board, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfsHelper(word, board, index + 1, x, y, visited)) {
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private static class TreeNode {
        TreeNode[] children;
        boolean isWord;
        public TreeNode() {
            this.children = new TreeNode[26];
        }
    }
    private class TrieBuild {      // ------------------private usage right? ood?
        private TreeNode generate(String[] words) {
            TreeNode root = new TreeNode();
            for (String word : words) {
                insert(word, root);
            }
            return root;
        }
        private void insert(String word, TreeNode root) {
            for (int i = 0; i < word.length(); i ++) {
                int pos = word.charAt(i) - 'a';
                if (root.children[pos] == null) {
                    root.children[pos] = new TreeNode();
                }
                root = root.children[pos];
            }
            root.isWord = true;
        }
    }
    public List<String> boggleGameSolu2(char[][] board, String [] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return list;
        }
        TrieBuild trieBuild = new TrieBuild();
        TreeNode root = trieBuild.generate(words);
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                checkWord(root, board, i, j, list, new StringBuffer());
            }
        }
        return list;
    }
    private void checkWord(TreeNode root, char[][] board, int i, int j, List<String> list, StringBuffer pre) {
        if (root == null) {
            return;
        }
        if (root.isWord) {
            list.add(pre.toString());
            root.isWord = false;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] == '#') {
            return;
        }
        TreeNode cur = root.children[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int newI = i +dir[0];
            int newJ = j +dir[1];
            checkWord(cur, board, newI, newJ, list, pre.append(temp));
            pre.deleteCharAt(pre.length() - 1);
        }
        board[i][j] = temp;
    }
    public static void main(String [] args) {
        ZTrieBoggleGame zTrieBoggleGame = new ZTrieBoggleGame();
        char[][] chars = {{'a','p'}, {'a','o'}};
        String [] strings = {"ap","a", "p", "apoa", "apoaa"};
        System.out.println(zTrieBoggleGame.boggleGameSolu2(chars, strings));
    }
}
