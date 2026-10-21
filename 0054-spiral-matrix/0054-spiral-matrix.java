class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;


        while(top <= bottom && left <= right) {

            for(int j=left;j<=right;j++) {
                System.out.print(matrix[top][j] + " ");
                ans.add(matrix[top][j]);
            }
            top++;

            for(int i=top;i<=bottom;i++) {
                System.out.print(matrix[i][right] + " ");
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom) {
                for(int j=right;j>=left;j--) {
                    System.out.print(matrix[bottom][j]);
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int i=bottom;i>=top;i--) {
                    System.out.print(matrix[i][left]);
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }

        return ans;
    }
}