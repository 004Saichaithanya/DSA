class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.strip().split("[^a-zA-Z]+");

        HashSet<String> set = new HashSet<>();

        for (String x : banned)
            set.add(x.toLowerCase());

        // for(String word : words)
        //     System.out.print(word+" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // System.out.println(map);
        int maxFreq = 0;
        String maxStr = "";

        for (String key : map.keySet()) {
            if (!set.contains(key)) {
                if (maxFreq < map.get(key)) {
                    maxFreq = map.get(key);
                    maxStr = key;
                }
                // System.out.println(maxStr);
            }
        }

        return maxStr;
    }
}