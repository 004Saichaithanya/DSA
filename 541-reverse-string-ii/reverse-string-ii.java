class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();

        if (n > k) {
            for (int i = 0; i < n; i += 2 * k) {
                chars = reverseString(chars, i, Math.min(i + k - 1, n - 1));
                System.out.println(chars);
            }
        } else {
            chars = reverseString(chars, 0, n - 1);
        }

        return new String(chars);
    }

    char[] reverseString(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}