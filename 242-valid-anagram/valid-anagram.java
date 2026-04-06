class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] hash = new int[26];

        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            hash[ch - 'a']--;
        }

        for (int x : hash) {
            if (x != 0)
                return false;
        }

        return true;

    }
}