class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[')
                stk.push(ch);
            else if (ch == ']') {
                if (!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else
                    return false;
            } else if (ch == '{')
                stk.push(ch);
            else if (ch == '}') {
                if (!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else
                    return false;
            } else if (ch == '(')
                stk.push(ch);
            else if (ch == ')') {
                if (!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else
                    return false;
            }
        }

        return stk.isEmpty();
    }
}