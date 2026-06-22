class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //System.out.println(s);

        StringBuilder cleanStr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (isAlphaNumeric(ch)) {
                cleanStr.append(ch);
            }
        }
       // System.out.println(cleanStr);
        int n = cleanStr.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (cleanStr.charAt(i) != cleanStr.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    boolean isAlphaNumeric(char ch) {
        if (Character.isLetter(ch) || Character.isDigit(ch))
            return true;
        return false;
    }
}