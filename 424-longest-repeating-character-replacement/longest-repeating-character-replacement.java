class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxF = 0, maxLen = 0;

        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(end)));
            int len = end - start + 1;
            if (len - maxF <= k) {
                maxLen = Math.max(maxLen, len);
            } else {
                while (start < n && (end-start+1) - maxF > k) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                    maxF=0;
                    for (int x : map.values())
                        maxF = Math.max(x, maxF);
                }
            }
            end++;
        }

        return maxLen;
    }
}