class Solution {
    private static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' 
            || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U' ) return true;
        return false;
    }
    public static String reverseVowels(String s) {
        int Lp  = 0, Rp = s.length()-1;
        StringBuffer sb = new StringBuffer(s);
        while(Lp <= Rp) {
            if(isVowel(sb.charAt(Lp)) && isVowel(sb.charAt(Rp))) {
                char ch = sb.charAt(Lp);
                sb.setCharAt(Lp, sb.charAt(Rp));
                sb.setCharAt(Rp, ch);
            }
            else if(isVowel(sb.charAt(Lp))) {
                Rp--;
            }
            else {
                Lp++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseVowels(str));
    }
}
