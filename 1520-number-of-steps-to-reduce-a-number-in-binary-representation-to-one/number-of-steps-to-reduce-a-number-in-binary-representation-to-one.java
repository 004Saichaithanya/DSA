class Solution {
    public int numSteps(String s) {
        int carry=0;
        int steps=0;
        int len=s.length();
        for(int i=len-1;i>=1;i--){
            int eff_bit = (s.charAt(i) - '0') + carry;
            if((eff_bit & 1) == 0 ){
                steps++;
            }else{
                steps+=2;
                carry=1;
            }
        }

        return (carry == 1)?carry+steps:steps;
    }
}