class Solution {
    public int countMagicalPairs(String s) {
        
        long ans = 0;
        int n = s.length();

        for(int j=0;j+1<n;j++) {

            int[] L = new int[27];
            int[] R = new int[27];

            int[] freq = new int[26];
            int distinct = 0;
            for(int i=j;i>=0;i--) {
                int c = s.charAt(i) - 'a';
                if(freq[c]++ == 0) distinct++;
                L[distinct]++;
            }

            freq = new int[26];
            distinct = 0;

            for(int k=j+1;k<n;k++) {
                int c = s.charAt(k) - 'a';
                if(freq[c]++ == 0) distinct++;
                R[distinct]++;
            }
            for(int d=1;d<=26;d++) {
            ans += (long) L[d] * R[d];
        }
        }
        return (int)ans;
    }
}