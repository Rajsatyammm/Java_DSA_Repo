 package Recursion;

 public class RemoveDuplicates {
    public static void removeDup(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base Case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kaam
        char c = str.charAt(idx);
        if (map[str.charAt(idx)-'a'] == false) {
            newStr.append(c);
            map[str.charAt(idx)-'a'] = true;
        }
        removeDup(str, idx + 1, newStr, map);

    }

    public static void main(String[] args) {
        String str = "ssaaattttyyaammm";
        // System.out.println(removeDup(str));
        boolean map[] = new boolean[26];
        StringBuilder newStr = new StringBuilder();
        removeDup(str, 0, newStr, map);
    }
}
