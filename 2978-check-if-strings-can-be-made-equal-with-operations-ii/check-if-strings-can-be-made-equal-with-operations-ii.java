class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even=new int[26];
        int[] odd=new int[26];

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if(i % 2 == 0){
                even[ch - 'a']++;
            }
            else
                odd[ch - 'a']++;
        }

        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(i % 2 == 0)
                even[ch-'a']--;
            else
                odd[ch-'a']--;
        }

        boolean flag=true;

        for(int i=0;i<even.length;i++){
            if(even[i] != 0){
            flag=false;
            break;
            }
        }

        for(int i=0;i<odd.length;i++){
            if(odd[i] != 0){
            flag=false;
            break;
            }
        }


        return flag;
    }
}