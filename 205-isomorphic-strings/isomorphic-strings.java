class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> rev = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
                return false;
            else if (rev.containsKey(t.charAt(i)) && rev.get(t.charAt(i)) != s.charAt(i))
                return false;

            map.put(s.charAt(i), t.charAt(i));
            rev.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}