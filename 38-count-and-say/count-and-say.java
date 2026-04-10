class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String res = "1";

        for (int i = 2; i <= n; i++) {
            int cnt = 1;
            int m = res.length();
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < m - 1; j++) {
                if (res.charAt(j) == res.charAt(j + 1)) {
                    cnt++;
                } else {
                    temp.append(cnt).append(res.charAt(j));
                    cnt = 1;
                }
            }
            temp.append(cnt).append(res.charAt(m - 1));
            res = temp.toString();
            //System.out.println(res);
        }

        return res;
    }
}