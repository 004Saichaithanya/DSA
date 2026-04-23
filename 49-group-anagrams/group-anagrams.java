class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            String temp = strs[i];
            String key = isAnagram(temp);

            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            
            map.get(key).add(temp);
        }

        return new ArrayList<>(map.values());
    }

    public String isAnagram(String s) {

        int[] hash = new int[26];
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        for (int x : hash) {
            res.append(x).append('#');
        }

        return res.toString();

    }
}