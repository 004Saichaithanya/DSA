class Solution {
    public int myAtoi(String s) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (s.length() == 0)
            return 0;
        s = s.trim();
        int n = s.length();
        if (s.isEmpty())
            return 0;

        //  int isNumber=0;
        int sign = 1;
        //int other=0;
        StringBuilder sb = new StringBuilder();
        int i = 0;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-')
                sign = -1;
            i = 1;
        }

        //leading zeros
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        int ans = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            //overflow condtion
            if (ans > (max - digit) / 10)
                return (sign == -1) ? min : max;

            ans = ans * 10 + digit;
            i++;
        }

        return sign * ans;
    }
}