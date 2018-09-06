package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mileygao on 8/15/18.
 */
public class ZTrie {
    private static class Node {
        Node[] children;
        boolean isWord;
        int numWords;
        public Node() {
            this.children = new Node[26];
        }
    }
    private Node root = new Node();

    public boolean insert(String s) {
        if (s == null) {
            return false;
        }
        if (search(s)) {
            return false;
        }
        Node cur = root;
        for (int i = 0; i < s.length(); i ++) {
            int pos = s.charAt(i) - 'a';
            Node curInsert = cur.children[pos];
            if (curInsert == null) {
                cur.children[pos] = new Node();

            }
            cur.children[pos].numWords ++;
            cur = cur.children[pos];
        }
        cur.isWord = true;
        return true;
    }

    public boolean delete(String s) {
        if (s == null) {
            return false;
        }
        if (!search(s)) {
            return false;
        }
        Node cur = root;
        for (int i = 0; i < s.length(); i ++) {
            int pos = s.charAt(i) - 'a';
            Node curSearch = cur.children[pos];
            if (curSearch.numWords == 1) {
                cur.children[pos] = null;
                return true;
            }
            curSearch.numWords --;
            cur = curSearch;
        }
        cur.isWord = false;
        return true;
    }

    public boolean search(String s) {
        if (s == null) {
            return false;
        }
        Node cur = root;
        for (int i = 0; i < s.length(); i ++) {
            int pos = s.charAt(i) - 'a';
            Node curSearch = cur.children[pos];
            if (curSearch == null) {
                return false;
            }
            cur = curSearch;
        }
        return cur.isWord;
    }

    public List<String> startWith(String s) {
        Set<String> set = new HashSet<>();
        if (s == null) {
            return new ArrayList<>(set);
        }
        Node cur = root;
        for (int i = 0; i < s.length(); i ++) {
            int pos = s.charAt(i) - 'a';
            Node curSearch = cur.children[pos];
            if (curSearch == null) {
                return new ArrayList<>(set);
            }
            cur = curSearch;
        }
        dfs(cur, s, set);
        return new ArrayList<>(set);
    }
    private void dfs(Node cur, String pre, Set<String> set) {
        for (int i = 0; i < cur.children.length; i ++) {
            if (cur.children[i] != null) {
                dfs(cur.children[i], pre + (i + 'a'), set);
            } else {
                set.add(pre);
            }
        }
    }

    public List<String> findAllMatchWildCard(String target) {
        List<String> result = new ArrayList<>();
        if (target == null || target.length() == 0) {
            return result;
        }
        addMatchWild(target, 0, new StringBuffer(), result, root);
        return result;
    }
    private void addMatchWild(String target, int index, StringBuffer pre, List<String> result, Node root) {
        if (index == target.length()) {
            if (root.isWord) {
                result.add(pre.toString());
            }
            return;
        }
        if (target.charAt(index) == '?') {
            for (int i = 0; i < 26; i ++) {
                if (root.children[i] != null) {
                    addMatchWild(target, index + 1, pre.append((char)('a' + i)), result, root.children[i]);
                    pre.deleteCharAt(pre.length() - 1);
                }
            }
        } else {
            int pos = target.charAt(index) - 'a';
            if (root.children[pos] != null) {
                addMatchWild(target, index + 1, pre.append((char)(pos + 'a')), result, root.children[pos]);
                pre.deleteCharAt(pre.length() - 1);
            }
        }
    }
    public static void main(String [] args) {
        ZTrie zTrie = new ZTrie();
        zTrie.insert("app");
        zTrie.insert("apple");
        System.out.println(zTrie.search("app"));
        zTrie.delete("ap");
        System.out.println(zTrie.findAllMatchWildCard("ap?").get(0));
    }
}
