class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        String number  = Integer.toString(n);

        for(char ch : number.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int sum = 0;

        for(char key : map.keySet()){
            sum += (key - '0') * (map.get(key));
        }

        return sum;
    }
}