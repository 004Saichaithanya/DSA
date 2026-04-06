class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
                while (map.get(s.charAt(end)) > 1) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }
}