class Solution {
    public boolean rotateString(String s, String goal) {
        boolean flag=false;
        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<sb.length();i++){
            if(sb.toString().equals(goal)){
                flag=true;
                break;
            }
            char first=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
          //  System.out.println(sb);
        }
      //  System.out.println(flag);

        return flag;
    }
}