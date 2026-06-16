class Solution {
    public int digitFrequencyScore(int n) {

    int sum = 0;
    String temp = n+"";
    for(char ch : temp.toCharArray()){
        sum += ch - '0';
    }
    return sum;
    }
}