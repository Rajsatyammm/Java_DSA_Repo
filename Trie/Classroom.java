 package Trie;
import java.util.*;

public class Classroom {
    static class Node {
        Node[] child;
        boolean EOW;

        Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            EOW = false;
        }
    }

    static Node root = new Node();

    static void add(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            if (i == str.length() - 1) {
                curr.child[idx].EOW = true;
            }
            curr = curr.child[idx];
        }
    }

    static boolean search(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            if (i == str.length() - 1 && curr.child[idx].EOW == false) {
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }

    static boolean wordBreak(String str) {
        if(str.length() == 0) {
            return true;
        }
        Node curr = root;
        for (int i = 1; i <= str.length(); i++) {
            String first = str.substring(0, i);
            String second = str.substring(i);

            if(search(first) && wordBreak(second)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        String[] str = { "the", "a", "there", "their", "any" };
        for (int i = 0; i < str.length; i++) {
            add(str[i]);
        }

        // System.out.println(search("ther"));
        System.out.println(wordBreak("theanyther"));

    }
}
