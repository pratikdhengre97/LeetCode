class Solution {
    public void backtrack(int index,int parts, String s, StringBuilder curr, List<String> ans) {
        if(parts == 4) {
            if(index == s.length()) {
                ans.add(curr.toString());
            }
            return;
        }

        int remaining = s.length() - index;

        if(remaining < (4-parts) || remaining > 3 * (4-parts)) {
            return;
        }

        int num = 0;
        for(int i=index;i<Math.min(index+3, s.length());i++) {
            num = num * 10 + (s.charAt(i) - '0');

            if(i > index && s.charAt(index) == '0') {
                break;
            }

            if(num > 255) {
                break;
            }
            int oldLength = curr.length();
            if(parts > 0) {
                curr.append('.');
            }
            curr.append(s,index,i+1);

            backtrack(i+1,parts+1,s,curr,ans);

            curr.setLength(oldLength);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        if(s.length() < 4 || s.length() > 12) {
            return ans;
        }
        backtrack(0,0,s,new StringBuilder(), ans);

        return ans;
    }
}