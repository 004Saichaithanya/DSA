class Solution {
    public boolean closeStrings(String word1, String word2) {

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (char ch : word1.toCharArray()) {
            map1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            map2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((map1[i] > 0 && map2[i] == 0) || (map2[i] > 0 && map1[i] == 0)) {
                return false;
            }
        }

        for (int i = 0; i < map1.length; i++) {
            if (map1[i] == 0)
                continue;
            for (int j = 0; j < map2.length; j++) {
                if (map2[j] == -1)
                    continue;
                if (map1[i] == map2[j]) {
                    map1[i] = 0;
                    map2[j] = -1;
                    break;
                }
            }
        }
        boolean flag = true;

        for (int x : map1) {
            if (x != 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}