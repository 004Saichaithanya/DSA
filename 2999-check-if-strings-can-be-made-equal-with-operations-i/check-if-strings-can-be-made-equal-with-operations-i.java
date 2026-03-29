class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int i = 0, j = 2;
        String swap1;

        if(s1.equals(s2))
        return true;

        swap1 = "" + s1.charAt(j) + s1.charAt(i + 1) + s1.charAt(i) + s1.charAt(j + 1);
        // System.out.println(swap1);

        if (swap1.equals(s2))
            return true;

        i = 1;
        j = 3;

        swap1 = "" + swap1.charAt(0) + swap1.charAt(j) + swap1.charAt(i + 1) + swap1.charAt(i);

        if (swap1.equals(s2))
            return true;




        swap1 = "" + s1.charAt(0) + s1.charAt(j) + s1.charAt(i + 1) + s1.charAt(i);
        // System.out.println(swap1);

        if (swap1.equals(s2))
            return true;

        


        return false;
    }
}