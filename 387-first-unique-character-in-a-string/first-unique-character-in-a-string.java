class Solution {
    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, -2);

        int idx = -1;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (hash[x - 'a'] == -2)
                hash[x - 'a'] = i;
            else
                hash[x - 'a'] = -1;
        }
        for (char ch : s.toCharArray()) {
            if (hash[ch - 'a'] != -1) {
                idx = hash[ch - 'a'];
                break;
            }

        }

        return idx;

    }
}