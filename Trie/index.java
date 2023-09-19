package Trie;

public class index {

     static class Trie {
        static class Node {
            Node[] children;
            boolean eow;

            Node() {
                children = new Node[26];
                for (int i = 0; i < 26; i++)
                    children[i] = null;
                eow = false;
            }
        }

        static Node root = new Node();

        public void insert(String s) {
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                if (i == s.length() - 1) {
                    curr.children[idx].eow = true;
                }
                curr = curr.children[idx];
            }
        }

        public boolean search(String s) {
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    return false;
                } else {
                    if (i == s.length() - 1 && !curr.children[idx].eow) {
                        return false;
                    }
                    curr = curr.children[idx];
                }
            }
            return true;
        }

        public boolean wordBreak(String key) {
            if(key.length() == 0) return true;

            for(int i=1; i<=key.length(); i++) {
                String first = key.substring(0, i);
                String second = key.substring(i);

                if(search(first) && wordBreak(second)) return true;
            }
            return false;
        }

        public boolean hasPrefix(String s) {
            Node curr = root;
            for(int i=0; i<s.length(); i++) {
                int idx = s.charAt(i) - 'a';

                if(curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return true;
        }

        public int countNodes(Node root) {
            Node curr = root;
            int count = 0;
            if(curr == null) return 0;
            for(int i=0; i<26; i++) {
                if(curr.children[i] != null) {
                    count += countNodes(curr.children[i]);
                }
            }
            return count+1;
        }

        static String ans = "";
        public void wordWithAllPrefix(Node root, StringBuilder temp) {
            if(root == null) return;
            Node curr = root;
            for(int i=0; i<26; i++) {
                if (curr.children[i] != null && curr.children[i].eow) {
                    char ch = (char) (i + 'a');
                    temp.append(ch);
                    if (temp.length() > ans.length()) {
                        ans = temp.toString();
                    }
                    wordWithAllPrefix(curr.children[i], temp);
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
//        String[] str = {"cats","dog","sand","and","cat"};
        String[] str = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String s = "ababa";
        for(int i=0; i<str.length; i++) {
            t.insert(str[i]);
        }
        t.wordWithAllPrefix(Trie.root, new StringBuilder());
        System.out.println(Trie.ans);
//        for(int i=0; i<s.length(); i++) {
//            String suffix = s.substring(i);
//            t.insert(suffix);
//        }
//        System.out.println(t.countNodes(Trie.root));


    }
}
