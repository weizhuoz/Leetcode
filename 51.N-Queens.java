51. N-Queens
https://leetcode.com/problems/n-queens/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n<=0){
            return res;
        }
        List<Integer> cols = new ArrayList<>();
        helper(n, cols, res);
        return res;
    }
    private void helper(int n,List<Integer> cols, List<List<String>> res){
        if(cols.size()==n){
            res.add(draw(cols));
            return;
        }
        for(int colIndex=0; colIndex<n; colIndex++){
            if(!isValid(colIndex, cols) || cols.contains(colIndex)){
                continue;
            }
            cols.add(colIndex);
            helper(n, cols, res);
            cols.remove(cols.size()-1);
        }
    }
    
    private boolean isValid(int colIndex,List<Integer> cols){
        // the row Index of the queen will put in (row, colIndex)
        int row = cols.size();
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            if(cols.get(rowIndex) == colIndex){
                return false;
            }
            if(cols.get(rowIndex) == colIndex){
                return false;
            }
            if(cols.get(rowIndex) + rowIndex == row + colIndex){
                return false;
            }
            if(cols.get(rowIndex) - rowIndex == colIndex - row){
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<String> draw(List<Integer> cols){
        ArrayList<String> drawPic = new ArrayList<>();
        for(int i=0;i<cols.size();i++){
            String str = "";
           for(int j=0;j<cols.size();j++){
               if(cols.get(i) == j){
                   str = str + "Q";
               }else{
                   str = str + ".";
               }
              
           } 
            drawPic.add(str);
        }
        return drawPic;
    }
}