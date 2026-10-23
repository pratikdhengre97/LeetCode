class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> triangle = new ArrayList<>();

        for(int row=0;row<=rowIndex;row++) {

            List<Integer> current = new ArrayList<>();

            for(int col=0;col<=row;col++) {
                current.add(1);
            }

            for(int col=1;col<row;col++) {
                int value = triangle.get(row-1).get(col-1) + triangle.get(row-1).get(col);

                current.set(col, value); 
            }
            triangle.add(current);
            if(row == rowIndex) {
                return current;
            }
        }
        return ans;
    }
}