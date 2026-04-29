class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        int n = path.length();
        String fileName = "";

        for (int i = 0; i < n; i++) {

            while (i < n && path.charAt(i) != '/') {
                //if(path.charAt(i) == '.') dots++;
                fileName += path.charAt(i);
                i++;
            }
            if (fileName.equals(".")) {
                fileName = "";
                continue;
            } else if (fileName.equals("..")) {
                if (!stk.isEmpty())
                    stk.pop();
            } else if (!fileName.isEmpty()) {
                stk.push(fileName);
            }
            fileName = "";
            //System.out.println(fileName);
        }

        Stack<String> temp = new Stack<>();

        while (!stk.isEmpty()) {
            temp.push(stk.pop());
        }

        StringBuilder ans = new StringBuilder("/");

        while (!temp.isEmpty()) {
            if (temp.size() > 1)
                ans.append(temp.peek()).append("/");
            else
                ans.append(temp.peek());
            temp.pop();
        }

        //  System.out.println(stk);
        //System.out.println(ans.toString());

        return ans.toString();
    }
}