class Solution {
    public void duplicateZeros(int[] arr) {
        int i = 0, j = 0;
        int n = arr.length;
        while (i < n && j < n) {
            if (arr[i] == 0) {
                j = n - 1;
                while (j > i + 1) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                if (i + 1 < n)
                    arr[i + 1] = 0;
                i++;
            }
            i++;
        }
    }
}