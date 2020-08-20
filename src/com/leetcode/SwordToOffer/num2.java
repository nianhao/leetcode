package com.leetcode.SwordToOffer;

public class num2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while (row< matrix.length&&col>=0){
            if(target== matrix[row][col]) return true;
            else if(target<matrix[row][col]) col--;
            else row++;
        }

        return false;

    }


}
