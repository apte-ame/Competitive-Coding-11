// TC = O(2n) -> O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+"); set.add("-"); set.add("*"); set.add("/");
        for(String s : tokens){
            if(set.contains(s)){
                int first = st.pop();
                int second = st.pop();
                if(s.equals("+")){
                    st.push(second + first);
                }else if(s.equals("-")){
                    st.push(second - first);
                }else if(s.equals("*")){
                    st.push(second * first);
                }else if(s.equals("/")){
                    st.push(second / first);
                }
            } else { //i.e. its a number and not an operator
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}