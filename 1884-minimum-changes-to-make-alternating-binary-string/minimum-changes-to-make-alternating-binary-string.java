class Solution {
    public int minOperations(String s) {
        char s1=' ';
        char s2=' ';
        int c1=0,c2=0;
        boolean flag=true;

        for(int i=0;i<s.length();i++){
            if(flag == true){
                s1='1';
                s2='0';
                flag=false;
            }else{
                s1='0';
                s2='1';
                flag=true;
            }
            if(s.charAt(i) != s1)
            c1++;
            else
            c2++;
        }
        return Math.min(c1,c2);
    }
}