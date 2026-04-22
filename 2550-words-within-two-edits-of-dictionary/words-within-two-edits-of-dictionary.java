class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int d = dictionary.length;
        List<String> ans = new ArrayList<>();
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                int misMatch = findMismatch(queries[i], dictionary[j]);
                if (misMatch <= 2) {
              //  System.out.println(misMatch + " " + queries[i] + " " + dictionary[j]);
                    ans.add(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }

    int findMismatch(String q, String dict) {

        int misMatch = 0;

        int i = 0, j = 0;
        while (i < q.length() && j < dict.length()) {
            if (q.charAt(i) != dict.charAt(j))
                misMatch++;
            i++;
            j++;
        }

        return misMatch;
    }
}