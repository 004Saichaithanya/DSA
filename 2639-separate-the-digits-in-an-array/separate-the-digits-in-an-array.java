class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            String num = Integer.toString(nums[i]);
            int index = 0;
            while(index < num.length()) {
                list.add(num.charAt(index) - '0');
                index++;
            }
        }

        int[] seperated = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            seperated[i] = list.get(i);
        }

        return seperated;
    }
}