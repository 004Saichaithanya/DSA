class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int x : nums) {
            String num = Integer.toString(x);
            for(char ch : num.toCharArray()){
                list.add(ch - '0');
            }
        }

        int[] seperated = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            seperated[i] = list.get(i);
        }

        return seperated;
    }
}