 package Trie;
import java.util.*;

public class PrefixProblem {
    static class Node {
        Node[] child;
        boolean EOW;
        int freq;

        Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            EOW = false;
            freq = 1;
        }
    }

    static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < 26; i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            } else {
                curr.child[idx].freq++;
            }
            // if (i == str.length() - 1) {
            //     curr.child[idx].EOW = true; 
            // }
            curr = curr.child[idx];
        }
    }

    static String ans = "";

    public static String prefixProb(Node root, StringBuilder sb, String str) {
        if (root.freq == 1) {
            return ans;
        }
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (root.child[idx] != null && root.child[idx].freq > 1) {
                sb.append((char) idx + 'a');
                if(sb.length() > ans.length()) {
                    ans = sb.toString();
                }
            }
            prefixProb(root.child[idx], sb, str);
        }
        return ans;
    }

//    public static String longestCommonPrefix() {
//
//    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "duck", "dove", "dog"};

        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        System.out.println(prefixProb(root, new StringBuilder(), "zebra"));
        
    }
}
