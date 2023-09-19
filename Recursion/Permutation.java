package Recursion;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        //permutation("", "abc");
        System.out.println(permutationRet("", "abc"));
    }

    static void permutation(String p, String up) {
        if(up.length()==0) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0; i<=p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            permutation(f+ch+l, up.substring(1));
        }
    }

    static List<String> permutationRet(String p, String up) {
        if(up.length() == 0) {
            List<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>();
        for(int i=0; i<=p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            ans.addAll(permutationRet(f+ch+l, up.substring(1)));
        }
        return ans;
    }
}
