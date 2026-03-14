class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int i = 0, j = 1;

        if (k > 0) {
            int idx = 0, sum = 0;
            while (idx < k) {
                sum += code[j];
                j = (j + 1) % n;
                idx++;

            }
            res[0] = sum;
            i++;
            while (i < n) {
                res[i] = res[i - 1] - code[i] + code[j];
                i++;
                j = (j + 1) % n;
            }

        } else if (k < 0) {
            i = n - 1;
            j = n - 2;
            int idx = 0, sum = 0;
            while (idx < -k) {
                sum += code[j];
                j--;
                if (j == -1)
                    j = n - 1;
                idx++;

            }
            res[n - 1] = sum;
            i--;
            while (i >= 0) {
                res[i] = res[i + 1] - code[i] + code[j];
                i--;
                j--;
                if (j == -1)
                    j = n - 1;
            }
        }

        return res;

    }
}