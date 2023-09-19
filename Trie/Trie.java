 package Trie;
import java.util.*;

public class Trie {
    static class Node {
        Node[] child;
        boolean endOfWord;

        public Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    public static void insert(String str) {
        Node ptr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (ptr.child[idx] == null) {
                ptr.child[idx] = new Node();
            }

            // End of word : true
            if (i == str.length() - 1) {
                ptr.child[idx].endOfWord = true;
                // ptr.endOfWord = true;
            }
            ptr = ptr.child[idx];
        }
    }

    public static boolean search(String str) {
        Node ptr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (ptr.child[idx] == null) {
                return false;
            }
            if ((i == str.length() - 1) && (ptr.child[idx].endOfWord == false)) {
                return false;
            }
            ptr = ptr.child[idx];
        }
        return true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String first = key.substring(0, i);
            String second = key.substring(i);

            if (search(first) && wordBreak(second)) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                int val = countNodes(root.child[i]);
                count += val;
            }
        }
        return count + 1;
    }

    static String ans = "";

    public static String longestWord(Node root, StringBuilder sb) {
        if (root == null) {
            return ans;
        }

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null && root.child[i].endOfWord == true) {
                sb.append((char)(i + 'a'));
                if (ans.length() < sb.length()) {
                    ans = sb.toString();
                }
                longestWord(root.child[i], sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return ans;
    }

    // public static String longestCommonPrefix() {

    // }

    public static void main(String[] args) {
        // String[] str = { "the", "a", "there", "their", "any" };
         String[] words = { "i", "like", "sam", "samsung", "mobile" };
        // String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        // String words[] = {}
        // String key = "ilikesamsung";
        // Trie obj = new Trie();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String str = "ababa";

        // System.out.println(startsWith("lik"));

        // System.out.println(startsWith("lim"));

        // calculate suffix and insert into tries
        // for (int i = 0; i < str.length(); i++) {
        // String suffix = str.substring(i);
        // insert(suffix);
        // }

        // System.out.println(countNodes(root));
        System.out.println(longestWord(root, new StringBuilder()));
    }
}
