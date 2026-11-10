class Solution {
    public int calculateScore(int a, int b) {

        int s1 = countSetBits(a);
        int s2 = countSetBits(b);
        int ans = 0;

        if(s1 >= s2) {
            ans = s1*s2;
        }
        else {
            ans = s2/s1;
        }

        return ans;
        
    }
    public int countSetBits(int num) {
        int setBits = 0;
        while(num > 0) {
            int modulo = num%2;

            if(modulo > 0) {
                setBits++;
            }
            
            num = num/2;
            
        }
        return setBits;
    }
}