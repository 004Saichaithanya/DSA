class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return 0;
        int first = -1;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                first = i;
                while (i < n && j < m) {
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        i=first;
                        j = 0;
                        break;
                    }

                }
                if (j == m)
                    return first;

            }
            i++;
        }

        //System.out.println(i);

        return -1;
    }
}