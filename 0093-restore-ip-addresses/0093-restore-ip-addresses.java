class Solution {
    public void backtrack(int ind, int parts, String s, StringBuilder curr, List<String> ans) {
        if(parts == 4) {
            if(ind == s.length()) {
                ans.add(curr.toString());
            }
            return;
        }

        int remaining = s.length() - ind;

        if(remaining < (4-parts) || remaining > 3 * (4-parts)) {
            return;
        }

        int num = 0;
        for(int i=ind;i<Math.min(ind+3, s.length());i++) {
            num = num * 10 + s.charAt(i) - '0';
            if(i > ind && s.charAt(ind) == '0') {
                break;
            }
            if(num > 255) {
                break;
            }

            int oldLength = curr.length();

            if(parts > 0) {
                curr.append('.');
            }
            curr.append(s,ind,i+1);

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