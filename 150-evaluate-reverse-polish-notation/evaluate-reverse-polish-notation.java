class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            if (!op.contains(str)) {
                //number
                //  System.out.println(str);
                stk.push(str);
            } else {
                if (!stk.isEmpty()) {
                    int b = Integer.parseInt(stk.pop());
                    int a = Integer.parseInt(stk.pop());
                    //  System.out.println(a+" "+b);
                    int res = 0;
                    switch (str) {
                        case "+":
                            res = a + b;
                            break;
                        case "-":
                            res = a - b;
                            break;
                        case "*":
                            res = a * b;
                            break;
                        case "/":
                            res = a / b;
                            break;

                    }
                    stk.push(res + "");
                }
            }
        }

        return Integer.parseInt(stk.pop());
    }
}